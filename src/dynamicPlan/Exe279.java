package dynamicPlan;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-08 10:52
 */
public class Exe279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++)
        {
           int minn = Integer.MAX_VALUE;
           for (int j = 1; j * j <= i; j++)
           {
               minn = Math.min(minn, dp[i - j*j]);
           }
           dp[i] = minn + 1;
        }
        return dp[n];
    }
    /**写法2*/
    public int numSquares1(int n)
    {
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++)
        {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j * j <= i; j++)
            {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
    /**法2 BFS*/
    public int numSquares2(int n)
    {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        int level = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++)
            {
                int digit = queue.poll();
                for (int j = 1; j <= n; j++)
                {
                    int nodeValue = digit + j * j;
                    if (nodeValue == n)
                    {
                        return level;
                    }
                    if (nodeValue > n)
                    {
                        break;
                    }
                    if (!visited.contains(nodeValue))
                    {
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }
}
