package backTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-23 11:26
 */
public class Exercise60 {
    boolean[] visited;
    String ans;
    int count = 0;
    public String getPermutation(int n, int k) {
        visited = new boolean[n + 1];
        StringBuffer sb = new StringBuffer();
        backTrack(n, k, visited, 0, sb);
        return ans;
    }

    private void backTrack(int n, int k, boolean[] visited, int pos, StringBuffer sb) {
        if (pos == n) {
            count++;
        }
        if (pos == n && count == k){
          ans = sb.toString();
        } else
        {
            for (int i = 1; i <= n; i++)
            {
                if (!visited[i])
                {
                    visited[i] = true;
                    sb.append(i);
                    backTrack(n, k, visited, pos + 1, sb);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    /**法2*/
    boolean[] used;
    int[] factorial;
    int n;
    int k;
    public String getPermutation1(int n, int k)
    {
        this.n = n;
        this.k = k;
        calculateFactorial(n);
        used = new boolean[n + 1];

        StringBuffer path = new StringBuffer();
        dfs(0, path);
        return path.toString();
    }

    /**
     * 算法设计是通过计算第K个排列应在哪个区间，直接来到叶节点，因此不需要回溯
     * */
    private void dfs(int index, StringBuffer path) {
        if (index == n)
        {
            return;
        }
        int count = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++)
        {
            if (used[i])
            {
                continue;
            }
            if (count < k)
            {
                k -= count;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1, path);
            return;
        }
    }

    /**计算阶乘数组*/
    private void calculateFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    /**链表实现*/
    public String getPermutation2(int n, int k)
    {
        k--;
        //维护一个阶乘数组
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++)
        {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();

        //i表示剩余的数字个数， 初始化为 n - 1
        for (int i = n - 1; i >= 0; i--)
        {
            int index = k / factorial[i];
            sb.append(nums.remove(index));
            k -= index * factorial[i];
        }
        return sb.toString();
    }
}
