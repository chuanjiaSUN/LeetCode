package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-01 14:00
 */
public class DiffPathExe62 {
    /**法1 回溯  超时*/
    int ans = 0;
    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        dfs(visited, m, n, 0, 0);
        return ans;
    }

    private void dfs(boolean[][] visited, int m, int n, int x, int y) {
        if (x == m - 1 && y == n - 1)
        {
            ans++;
            return;
        }
        if (x >= m || y >= n)
        {
            return;
        }
        if (!visited[x][y])
        {
            visited[x][y] = true;
            dfs(visited, m, n, x + 1, y);
            dfs(visited, m, n, x , y + 1);
            visited[x][y] = false;
        }
    }
    /**法2 dp*/
    public int uniquePaths1(int m, int n)
    {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++)
        {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
