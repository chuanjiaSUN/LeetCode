package dynamicPlan;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-08 11:54
 */
public class Exe309 {
    public int maxProfit(int[] prices) {
        if (prices == null)
        {
            return 0;
        }
        int len = prices.length;
        if (len == 0)
        {
            return 0;
        }
        int[][] dp = new int[len][3];
        //持有
        dp[0][0] = -prices[0];
        //卖了，冷冻
        dp[0][1] = 0;
        //卖了，不冷冻
        dp[0][2] = 0;
        for (int i = 1; i < len; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }
}
