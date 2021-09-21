package dynamicPlan;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-21 11:32
 */
public class Exe646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int j = 1; j < n; j++)
        {
            for (int i = 0; i < j; i++)
            {
                if (pairs[i][1] < pairs[j][1])
                {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int ans = 0;
        for (int d : dp)
        {
            ans = Math.max(ans, d);
        }
        return ans;
    }
}
