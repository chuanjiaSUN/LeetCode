package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-23 11:29
 */
public class Exe714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
    /**空间优化*/
    public int maxProfit1(int[] prices, int fee)
    {
        int len = prices.length;
        int buy = -prices[0], sales = 0;
        int cBuy = buy, cSales = sales;
        for (int i = 1; i < len; i++)
        {
            cBuy = Math.max(sales - prices[i], buy);
            cSales = Math.max(sales, buy + prices[i] - fee);
            buy = cBuy;
            sales = cSales;
        }
        return sales;
    }
    public int maxProfit2(int[] prices, int fee) {
        int len = prices.length;
        int buy = -prices[0], sales = 0;
        for (int i = 1; i < len; i++)
        {
            sales = Math.max(sales, buy + prices[i] - fee);
            buy = Math.max(buy, sales - prices[i]);
        }
        return sales;
    }
    /**贪心*/
    public int maxProfit3(int[] prices, int fee)
    {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; i++)
        {
            if (prices[i] + fee < buy)
            {
                buy = prices[i] + fee;
            }else if (prices[i] > buy)
            {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
