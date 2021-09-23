package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-23 10:31
 */
public class Exe712 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = len1 - 1; i >= 0; i--) {
            dp[i][len2] = dp[i + 1][len2] + s1.codePointAt(i);
        }
        for (int j = len2 - 1; j >= 0; j--) {
            dp[len1][j] = dp[len1][j + 1] + s2.codePointAt(j);
        }
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.codePointAt(i),
                            dp[i][j + 1] + s2.codePointAt(j));
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 转化为最长子序
     */
    public int minimumDeleteSum1(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++)
        {
            for (int j = 0; j < len2; j++)
            {
                if (s1.charAt(i) == s2.charAt(j))
                {
                    dp[i + 1][j + 1] = dp[i][j] + s1.charAt(i);
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int dels = dp[len1][len2] * 2;
        for (int i = 0; i < len1; i++)
        {
            dels -= s1.codePointAt(i);
        }
        for (int j = 0; j < len2; j++)
        {
            dels -= s2.codePointAt(j);
        }
        return -dels;
    }
}
