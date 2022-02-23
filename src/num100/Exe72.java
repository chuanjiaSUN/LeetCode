package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-21 15:11
 */
public class Exe72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left =  dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[m][n];
    }
}
