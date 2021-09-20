package dynamicPlan;

import java.util.logging.Level;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-20 20:16
 */
public class Exe583 {
    public int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * dfs(word1, word2, word1.length(), word2.length());
    }

    private int dfs(String s1, String s2, int len1, int len2) {
        if (len1 == 0 || len2 == 0)
        {
            return 0;
        }
        if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1))
        {
            return 1 + dfs(s1, s2, len1 - 1, len2  - 1);
        }else{
            return Math.max(dfs(s1, s2, len1, len2- 1), dfs(s1, s2, len1 - 1, len2));
        }
    }

    /**记忆化搜索*/
    public int minDistance1(String s1, String s2)
    {
        int[][] memo = new int[s1.length()][s2.length()];
        return s1.length() + s2.length() - 2 * dfs1(s1, s2, s1.length(), s2.length(), memo);
    }

    private int dfs1(String s1, String s2, int len1, int len2, int[][] memo) {
        if (len1 == 0 || len2 == 0)
        {
            return 0;
        }
        if (memo[len1][len2] != 0)
        {
            return memo[len1][len2];
        }
        if (s1.charAt(len1) == s2.charAt(len2))
        {
            memo[len1][len2] =  1 + dfs1(s1, s2, len1 - 1, len2 - 1, memo);
        }else{
            memo[len1][len2] = Math.max(dfs1(s1, s2, len1 - 1,len2, memo), dfs1(s1, s2, len1, len2 - 1, memo));
        }
        return memo[len1][len2];
    }

    /**动态规划*/
    public int minDistance2(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
        {
            for(int j = 0; j <= len2; j++)
            {
                if (i == 0 || j == 0)
                {
                    continue;
                }
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][ j - 1]);
                }
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }

    /**动规2*/
    public int minDistance3(String s1, String s2)
    {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++)
        {
            for (int j = 0; j <= len2; j++)
            {
                if (i == 0||j==0)
                {
                    dp[i][j] = i + j;
                }else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**空间优化*/
    public int minDistance4(String s1, String s2)
    {
        int len1 =  s1.length(), len2 = s2.length();
        int[] dp = new int[len2 + 1];
        for (int i = 0; i <= len1; i++)
        {
            int[] temp = new int[len2 + 1];
            for (int j = 0; j <= len2; j++)
            {
                if (i == 0 || j == 0)
                {
                    temp[j] = i + j;
                }else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                {
                    temp[j] = dp[j - 1];
                }else{
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
                }
            }
            dp = temp;
        }
        return dp[len2];
    }

}
