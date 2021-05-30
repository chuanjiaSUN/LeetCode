package String.day09;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-27 11:35
 */
public class exercise97_prac {
    public boolean isInterleave(String s1, String s2, String s3)
    {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i > 0)
                {
                    dp[j] = dp[j] && s1.charAt(i-1) == s3.charAt( i + j - 1);
                }
                if (j > 0)
                {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt( j - 1) == s3.charAt( i + j - 1));
                }
            }
        }
        return dp[n];
    }

}
