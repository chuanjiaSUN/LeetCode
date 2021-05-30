package Arrays.day27;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-02 10:10
 */
public class DongGui_TanXin_exercise714 {
    //法1 ：动态规划
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] f = new int[length][2];
        f[0][0] = 0;
        f[0][1] = -prices[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 1; i < length ; i++)
        {
            f[i][1] = Math.max(f[i-1][1],f[i-1][0] - prices[i]);
            f[i][0] = Math.max(f[i-1][0],f[i-1][1] + prices[i] - fee);
            maxProfit = Math.max(f[i][1],f[i][0]);
        }
        return maxProfit==Integer.MIN_VALUE?0:maxProfit;
    }
    //法2 ：在法1的动态规划转移方程中，f[i][1],f[i][0]只会从f[i-1][1]与f[i-1][0]转移过来
    //  因此，不用使用二维数组存储所有的状态，使用两个变量Buy与sell进行转移
    public int maxProfit1(int[] prices, int fee)
    {
        int length = prices.length;
        int[] f = new int[length];
        int sell = 0;
        int buy = -prices[0];
        for(int i = 1; i < length; i++)
        {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    //法3 贪心
    public int maxProfit2(int[] prices, int fee)
    {
        int length = prices.length;
        int buy = prices[0] + fee;//buy表示在最大化收益的前提下，手上有一直股票，那么它的最低买入价是多少
        int profit = 0;
        for( int i = 1; i < length; i++)
        {
            if(prices[i] + fee < buy)
            {
                buy = prices[i] + fee;
            }else if( prices[i] > buy)
            {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
    public static void main(String[] args) {
        DongGui_TanXin_exercise714 e = new DongGui_TanXin_exercise714();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int i = e.maxProfit(prices, 2);
        System.out.println(i);
    }
}
