package dynamicPlan;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-09 10:53
 */
public class Exe322 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        int len = coins.length;
        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < len; j++)
            {
                if (coins[j] <= i)
                {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
