package dynamicPlan;


import java.lang.reflect.Proxy;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-04 8:51
 */
public class BestSaleExe123 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][][] dp = new int[length][2][3];
        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        int minValue = Integer.MIN_VALUE / 2;
        dp[0][0][1] = minValue;
        dp[0][0][2] = minValue;
        dp[0][1][1] = minValue;
        dp[0][1][2] = minValue;
        for (int i = 1; i < length; i++)
        {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = minValue;
        }
        return Math.max(0, Math.max(dp[length - 1][0][1], dp[length - 1][0][2]));
    }
    /**空间优化*/
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        int buy1 = -prices[0], buy2 = -prices[0];
        int sale1 = 0,sale2 = 0;
        for (int i = 1; i <length; i++)
        {
            buy1 = Math.max(buy1, -prices[i]);
            sale1 = Math.max(buy1 + prices[i], sale1);
            buy2 = Math.max(sale1 - prices[i], buy2);
            sale2 = Math.max(buy2 + prices[i], sale2);
        }
        return sale2;
    }
}
