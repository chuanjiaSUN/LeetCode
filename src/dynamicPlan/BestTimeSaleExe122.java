package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-03 10:51
 */
public class BestTimeSaleExe122 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0 ;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    /**优化空间*/
    public int maxProfit1(int[] prices)
    {
        int length = prices.length;
        int noStock = 0, stock = -prices[0];
        for (int i = 1; i < length; i++)
        {
            noStock = Math.max(noStock, stock + prices[i]);
            stock = Math.max(stock, noStock - prices[i]);
        }
        return noStock;
    }

    /**贪心*/
    public int maxProfit2(int[] prices)
    {
        int sum = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++)
        {
            sum += prices[i] >= prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return sum;
    }
}
