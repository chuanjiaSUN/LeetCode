package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-15 22:24
 */
public class Pre63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i - 1][0] != 1){
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < n; j++){
            if (obstacleGrid[0][j - 1] != 1){
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] += obstacleGrid[i - 1][j] == 1 ? 0 : dp[i - 1][j];
                dp[i][j] += obstacleGrid[i][j - 1] == 1 ? 0 : dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
