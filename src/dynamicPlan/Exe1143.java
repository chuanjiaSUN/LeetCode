package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 22:51
 */
public class Exe1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++)
        {
            char c = text1.charAt(i - 1);
            for (int j = 1; j <= len2; j++)
            {
                char c1 = text2.charAt(j - 1);
                if (c == c1)
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
