package backTracking;


import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-01 12:38
 */
public class Exercise967 {
    /**
     * DFS + 回溯
     */
    List<Integer> ans;
    static final int INT_BOUND = 9;
    static final int ADD_BOUND = 10;

    public int[] numsSameConSecDiff(int n, int k) {
        ans = new ArrayList<>();
        for (int i = 1; i <= INT_BOUND; i++) {
            if (i + k > INT_BOUND && i - k < 0) {
                continue;
            }
            dfs(new StringBuilder(String.valueOf(i)), n, k);
        }
        int[] nums = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            nums[i] = ans.get(i);
        }

        return nums;
    }

    private void dfs(StringBuilder sb, int n, int k) {
        if (sb.length() == n) {
            ans.add(Integer.valueOf(sb.toString()));
            return;
        }

        int num = sb.charAt(sb.length() - 1) - '0';
        if (num + k < ADD_BOUND) {
            sb.append(num + k);
            dfs(sb, n, k);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (num - k >= 0 && k != 0) {
            sb.append(num - k);
            dfs(sb, n, k);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 法2 BFS
     */
    public int[] numsSameConSecDiff1(int n, int k) {
        return bfs(1, n, k, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10);
    }

    private int[] bfs(int level, int n, int k, int[] curr, int len) {
        if (level == n) {
            return Arrays.copyOfRange(curr, 0, len);
        }

        int[] next = new int[len * 2];
        int i = 0;
        for (int j = 0; j < len; j++) {
            //上一层的结果 val
            int v = curr[j];
            if (v > 0) {
                int d = v % 10;
                if (d + k <= 9) {
                    next[i++] = v * 10 + d + k;
                }
                if (d - k >= 0 && k > 0) {
                    next[i++] = v * 10 + d - k;
                }
            }
        }
        return bfs(level + 1, n, k, next, i);
    }

    /**
     * BFS 2
     */
    public int[] numsSameConSecDiff2(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        while (n > 1)
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                int cur = queue.poll();
                int last = cur % 10;
                if (last + k < 10)
                {
                    queue.offer(cur * 10 + last + k);
                }
                if (last - k >= 0 && k != 0)
                {
                    queue.offer(cur * 10 + last - k);
                }
            }
            n--;
        }
        int len = queue.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++)
        {
            res[i] = queue.poll();
        }
        return res;
    }

}

