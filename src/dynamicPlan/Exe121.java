package dynamicPlan;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-03 10:27
 */
public class Exe121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        int length = prices.length;
        for (int i = 0; i < length; i++)
        {
            if (prices[i] < minPrice)
            {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > profit)
            {
                profit = prices[i] - minPrice;
            }

        }
        return profit;
    }
}
