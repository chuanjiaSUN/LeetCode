package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-18 11:40
 */
public class Exe516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--)
        {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++)
            {
                char c2 = s.charAt(j);
                if (c1 == c2)
                {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**从左到右枚举*/
    public int longestPalindromeSubseq1(String s)
    {
        int n = s.length();
        char[] str = s.toCharArray();
        int[][] f = new int[n][n];
        for (int len = 1; len <= n; len++)
        {
            for (int l = 0; l + len - 1 < n; l++)
            {
                int r = l + len - 1;
                if (len == 1)
                {
                    f[l][r] = 1;
                }else if (len == 2)
                {
                    f[l][r] = str[l] == str[r] ? 2 : 1;
                }else{
                    f[l][r] = Math.max(f[l + 1][r], f[l][r - 1]);
                    f[l][r] = Math.max(f[l][r], (f[l + 1][r - 1] + (str[l] == str[r] ? 2 : 0)));
                }
            }
        }
        return f[0][n - 1];
    }
}
