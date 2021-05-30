package String.day07;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 13:06
 */
public class exercise72_prac {
    //二维数组动态规划  dp[i][j]由3个状态转移过来 即
    public int minDistance(String word1, String word2)
    {
        int len1 = word1.length();
        int len2 = word2.length();
        if (word1 == null || word2 == null)
        {
            return len1+len2;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        for (int i = 1; i <= len1; i++)
        {
            for (int j = 1; j <= len2; j++)
            {
                if (word1.charAt(i-1) == word2.charAt( j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i-1][j]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    //滚动数组优化， 因为dp[i][j]只与三个值有关
    public int minDistance1(String word1, String word2)
    {
        int len1 = word1.length();
        int len2 = word2.length();
        if (word1 == null || word2 == null) return len1 + len2;
        int[] dp = new int[ len2 + 1];
        for (int i = 0; i <= len2; i++) dp[i] = i; //初始化边界条件，即dp[0][j]

        for (int i = 1; i <= len1; i++)
        {
            int prev = dp[0];//记录dp[i-1][j-1]
            dp[0] = i; //更新下一行开始时的dp[i-1][j-1] 也就是dp[i][0]
            for (int j = 1; j <= len2; j++)
            {
                int curr = dp[j];//记录当前状态
                if (word1.charAt( i - 1) == word2.charAt( j - 1)) dp[j] = prev;
                else dp[j] = Math.min(Math.min(dp[j], dp[j-1]), prev) + 1;
                prev = curr;//更新 i-1 j-1的状态
            }
        }
        return dp[len2];
    }
}
