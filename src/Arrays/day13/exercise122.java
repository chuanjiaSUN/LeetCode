package Arrays.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-19 15:24
 */
public class exercise122 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int Profit = 0;
        for(int i=0;i<length;i++)
        {
            if(prices[i]<minPrice)
            {
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit)
            {
                maxProfit = prices[i] - minPrice;
                Profit += maxProfit;
                minPrice = Integer.MAX_VALUE;
                maxProfit = 0;
                i = i-1;
            }
        }
        return Profit;
    }

    //法2 动态规划
    public int maxProfit1(int[] prices){
        int length = prices.length;
        int[][] profit = new int[length][2];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];
        for(int i=1;i<length;i++)
        {
            profit[i][0] = Math.max(profit[i-1][0],profit[i-1][1]+prices[i]);
            profit[i][1] = Math.max(profit[i-1][0]-prices[i],profit[i-1][1]);
        }
        return profit[length-1][0];
    }

    //法3 贪心
    public int maxProfit2(int[] prices){
        int n = prices.length;
        int maxProfit = 0;
        for(int i=1;i<n;i++)
        {
            maxProfit += Math.max(prices[i]-prices[i-1],0);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        exercise122 e = new exercise122();
        int i = e.maxProfit(prices);
        System.out.println(i);
    }
}
