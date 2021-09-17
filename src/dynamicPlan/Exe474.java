package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-17 10:15
 */
public class Exe474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++)
        {
            int[] zerosOnes = getZerosOnes(strs[i - 1]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = 0; j <= m; j++)
            {
                for (int k = 0; k <= n; k++)
                {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j>=zeros && k >= ones)
                    {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }

    private int[] getZerosOnes(String str) {
        int[] ans = new int[2];
        int count = 0, len = str.length();
        for (int i = 0; i < len; i++)
        {
            ans[str.charAt(i) - '0']++;
        }
        return ans;
    }
}
