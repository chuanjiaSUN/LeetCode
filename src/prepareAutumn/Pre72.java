package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-20 23:33
 */
public class Pre72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null){
            return 0;
        }
        if (word1 == null){
            return word2.length();
        }
        if (word2 == null){
            return word1.length();
        }
        int m = word1.length();
        int n = word2.length();
        if (n * m == 0){
            return n + m;
        }
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i <= n; i ++){
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++){
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                int first = dp[i -1][j] + 1;
                int second = dp[i][j - 1] + 1;
                int third = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    third += 1;
                }
                dp[i][j] = Math.min(first, Math.min(second, third));
            }
        }
        return dp[m][n];
    }
}
