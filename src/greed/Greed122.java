package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-09 11:36
 */
public class Greed122 {
    public int maxProfit(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
    /**动规优化*/
    public int maxProfit1(int[] prices)
    {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; i++)
        {
            int temp = sell;
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, temp - prices[i]);
        }
        return Math.max(sell, buy);
    }

    /**贪心*/
    public int maxProfit2(int[] prices)
    {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++)
        {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
