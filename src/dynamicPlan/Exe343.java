package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-09 11:29
 */
public class Exe343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++)
        {
            int curMax = 0;
            for (int j = 1; j < i; j++)
            {
                curMax = Math.max(curMax, Math.max(dp[i - j] * j, j * (i - j)));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
    /**优化*/
    public int integerBreak1(int n)
    {
        if (n < 4)
        {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
        {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
}
