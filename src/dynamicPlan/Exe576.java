package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-20 14:17
 */
public class Exe576 {
    /**记忆化搜索*/
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][][] cache;
    final int MOD = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k <= maxMove; k++)
                {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(m, n, startRow, startColumn, maxMove);
    }

    private int dfs(int m, int n, int x, int y, int k) {
        if (x < 0 || x >= m || y < 0 || y >= n)
        {
            return 1;
        }
        if (k == 0)
        {
            return 0;
        }
        if (cache[x][y][k] != -1)
        {
            return cache[x][y][k];
        }
        int ans = 0;
        for (int[] dir :dirs)
        {
            int newX = x + dir[0], newY = y + dir[1];
            ans += dfs(m, n, newX, newY, k - 1);
            ans %= MOD;
        }
        cache[x][y][k] = ans;
        return ans;
    }

    /**动规*/
    int m, n, max;
    public int findPaths1(int m, int n, int maxMove, int startRow, int startColumn)
    {
        this.m = m;
        this.n = n;
        this.max = maxMove;
        int[][] f = new int[m * n][maxMove + 1];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == 0) {
                    add(i, i, f);
                }
                if (j == 0){
                    add(i, j, f);
                }
                if (i == m -1) {
                    add(i, j, f);
                }
                if (j == n - 1) {
                    add(i, j, f);
                }
            }
        }
        for (int k = 1; k <= max; k++)
        {
            for (int idx = 0; idx < m * n; idx++)
            {
                int[] info = parseIdx(idx);
                int x = info[0], y = info[1];
                for (int[] dir : dirs)
                {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx <0 || nx >= m || ny < 0 || ny >= n)
                    {
                        continue;
                    }
                    int nidx = getIndex(nx, ny);
                    f[idx][k] += f[nidx][k - 1];
                    f[idx][k] %= MOD;
                }
            }
        }
        return f[getIndex(startRow, startColumn)][maxMove];
    }

    private void add(int x, int y, int[][] f) {
        for (int k = 1; k <= max; k++)
        {
            f[getIndex(x, y)][k]++;
        }
    }

    private int getIndex(int x, int y) {
        return x * n + y;
    }
    int[] parseIdx(int idx)
    {
        return new int[]{idx / n, idx % n };
    }

    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn)
    {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++)
        {
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    int count = dp[i][j][k];
                    if (count > 0)
                    {
                        for (int[] dir : directions)
                        {
                            int j1 = j + dir[0], k1 = k + dir[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n)
                            {
                                dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % MOD;
                            }else{
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return outCounts;
    }
    /**空间优化*/
    public int findPaths3(int m, int n, int maxMove, int startRow, int startColumn)
    {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++)
        {
            int[][] dpNew = new int[m][n];
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    int count = dp[j][k];
                    if (count > 0)
                    {
                        for (int[] dir : directions)
                        {
                            int j1 = j + dir[0], k1 = k + dir[1];
                            if (j1 >=0 && j1 < m && k1 >= 0 && k1 < n)
                            {
                                dpNew[j1][k1] = (dpNew[j1][k1] + count) % MOD;
                            }else{
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }

                }
            }
            dp = dpNew;
        }
        return outCounts;
    }
    int[][][] memo;
    int[][] directs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int findPaths4(int m, int n, int maxMove, int startRow, int startColumn)
    {
        memo = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k <= maxMove; k++)
                {
                    memo[i][j][k] = -1;
                }
            }
        }
        return dfs1(m, n, maxMove, startRow, startColumn, maxMove);
    }

    private int dfs1(int m, int n, int maxMove, int x, int y, int count) {
        if (x < 0 || x >= m || y < 0 || y >= n)
        {
            return 1;
        }
        if (count == 0)
        {
            return 0;
        }
        if (memo[x][y][count] != -1)
        {
            return memo[x][y][count];
        }
        int ans = 0;
        for (int[] direction : directs)
        {
            int newX = x + direction[0], newY = y + direction[1];
            ans += dfs1(m, n, maxMove, newX, newY, count - 1);
            ans = ans % MOD;
        }
        memo[x][y][count] = ans;
        return ans;
    }

}
