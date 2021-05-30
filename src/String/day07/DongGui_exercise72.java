package String.day07;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 10:43
 */
public class DongGui_exercise72 {
    //自底向上动态规划
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0)
        {
            return  n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
        {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++)
        {
            dp[0][i] = i;
        }

        for (int i = 1; i < n + 1; i++)
        {
            for (int j = 1; j < m + 1; j++)
            {
                int left = dp[ i  - 1][j] + 1;//对A执行删除操作
                int down = dp[i][j - 1] + 1;//对A执行添加操作
                int left_down = dp[i-1][j-1];//对A执行替换操作
                if ( word1.charAt(i - 1) != word2.charAt(j - 1))
                {
                    left_down += 1;
                }
                dp[i][j] = Math.min(left,Math.min(down,left_down));
            }
        }
        return dp[n][m];
    }
    //滚动数组优化
    //我们看到虽然dp是二维数组，但我们计算的时候每个元素只和他的左边，上边，左上角的3个值有关，所以这里我们还可以优化一下，使用一维数组，
    public int minDistance1(String word1, String word2)
    {
        int m = word1.length();
        int n = word2.length();
        if (m==0 || n==0)return m + n;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = i;
        for (int i = 1; i <= m; i++)
        {
           int prev = dp[0];       // 代表 i-1 j-1 的状态
            dp[0] = i; // i - 1的状态
           for (int j = 1; j <= n; j++)
           {
               int curr = dp[j];
               if (word1.charAt(i-1) == word2.charAt(j - 1)) dp[j] = prev;
               else dp[j] = Math.min(Math.min(dp[j],dp[j-1]), prev) + 1;
                prev = curr;
           }
        }
        return dp[n];
    }

}
