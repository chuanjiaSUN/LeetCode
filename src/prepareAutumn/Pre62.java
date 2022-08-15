package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-17 22:13
 */
public class Pre62 {
    int ans = 0;
    int[][] directions = {{1, 0},{0, 1}};
    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        dfs(0, 0,visited);
        return ans;
    }

    private void dfs(int i, int j, boolean[][] visited) {
        if (i == visited.length - 1 && j == visited[0].length - 1){
            ans++;
            return;
        }
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length){
            return;
        }
        visited[i][j] = true;
        for (int[] dir : directions){
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            if (newI >= 0 && newI < visited.length && newJ >= 0 && newJ < visited[0].length){
                if (!visited[newI][newJ]){
                    visited[newI][newJ] = true;
                    dfs(newI, newJ, visited);
                    visited[newI][newJ] = false;
                }
            }
        }
        visited[i][j] = false;
    }

    /**动态*/
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    /**
     * practice
     * */
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
