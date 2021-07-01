package backtrackrevise;

import sun.rmi.log.LogInputStream;

import java.awt.geom.Area;
import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-01 15:00
 */
public class Exe967 {
    /**法1 BFS*/
    public int[] numsSameConSecDiff(int n, int k)
    {
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
        int[] ans = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++)
        {
            ans[i] = queue.poll();
        }
        return ans;
    }

    /**法2 DFS*/
    List<Integer> ans;
    static final int NUM_UPPER_BOUND = 9;
    public int[] numsSameConSecDiff1(int n, int k)
    {
        ans = new ArrayList<>();
        for (int i = 1; i < NUM_UPPER_BOUND; i++)
        {
            dfs(new StringBuilder(i), n, k);
        }
        int len = ans.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++)
        {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void dfs(StringBuilder digits, int n, int k) {
        if (digits.length() == n)
        {
            ans.add(Integer.valueOf(digits.toString()));
            return;
        }
        int num = digits.toString().charAt(digits.length() - 1) - '0';
        if (num + k <= NUM_UPPER_BOUND)
        {
            digits.append(num + k);
            dfs(digits, n, k);
            digits.deleteCharAt(digits.length() - 1);
        }
        if (num - k >= 0 && k != 0)
        {
            digits.append(num - k);
            dfs(digits, n, k);
            digits.deleteCharAt(digits.length() - 1);
        }
    }
}
