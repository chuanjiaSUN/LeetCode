package dynamicPlan;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-24 14:28
 */
public class Exe764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        int[][] dp = new int[n][n];
        for (int[] mine : mines)
        {
            banned.add(mine[0] * n + mine[1]);
        }
        int ans  = 0, count;

        for (int r = 0; r < n; r++)
        {
            count = 0;
            for(int c = 0; c < n; c++)
            {
                count = banned.contains(r * n + c) ? 0 : count  + 1;
                dp[r][c] = count;
            }
            count = 0;
            for (int c = n - 1; c >= 0; c--)
            {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }

        for (int c = 0; c < n; c++)
        {
            count = 0;
            for (int r = 0; r < n; r++)
            {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            count = 0;
            for (int r = n - 1; r >= 0; r--)
            {
                count = banned.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }
        return ans;
    }
    public int orderOfLargestPlusSign1(int n, int[][] mines){
        //dp[][][0]为左，1为上,2为右，3为下
        int[][][] dp = new int[n][n][4];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < 4; k++)
                {
                    dp[i][j][k] = 1;
                }
            }
        }
        for (int[] mine : mines)
        {
            for (int k = 0; k < 4; k++)
            {
                dp[mine[0]][mine[1]][k] = 0;
            }
        }
        //算左 和 上 的臂长
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < n; j++)
            {
                if (dp[i][j][0] == 0)
                {
                    continue;
                }
                dp[i][j][0] = 1 + dp[i][j - 1][0];
                dp[i][j][1] = 1 + dp[i - 1][j][1];
            }
        }
        //算右和下
        for (int i = n - 2; i >= 0; i--)
        {
            for (int j = n - 2; j >= 0; j--)
            {
                if (dp[i][j][2] == 0)
                {
                    continue;
                }
                dp[i][j][2] = 1 + dp[i][j + 1][2];
                dp[i][j][3] = 1 + dp[i + 1][j][3];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int k = Math.min(Math.min(dp[i][j][0],dp[i][j][1]),Math.min(dp[i][j][2],dp[i][j][3]));
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

}
