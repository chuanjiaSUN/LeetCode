package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-03 21:17
 */
public class Exercise1219 {
    int ans = Integer.MIN_VALUE;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i][j] != 0)
                {
                    visited[i][j] = true;
                    backTrack(grid, i, j, grid[i][j] ,visited);
                    visited[i][j] = false;
                }
            }
        }
        return ans;
    }

    private void backTrack(int[][] grid, int x, int y, int count, boolean[][] visited) {
        if (x >= 0 && x < grid[0].length && y >= 0 && y < grid[0].length)
        {
            ans = Math.max(ans, count);
        }
        for (int[] dir : directions)
        {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX >=0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] != 0)
            {
                if (!visited[newX][newY])
                {
                    visited[newX][newY] = true;
                    backTrack(grid, newX, newY, count + grid[newX][newY], visited);
                    visited[newX][newY] = false;
                }
            }
        }
    }

    /**法2*/
    public int getMaximumGold1(int[][] grid)
    {
        if (grid == null || grid.length == 0)
        {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private static final int END_DFS = 0;
    private int dfs(int[][] grid, int i, int j) {
        if ( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == END_DFS)
        {
            return 0;
        }
        int temp = grid[i][j];
        grid[i][j] = 0;
        int up = dfs(grid, i, j + 1);
        int down = dfs(grid, i, j - 1);
        int left = dfs(grid, i - 1, j);
        int right = dfs(grid, i + 1, j);
        int max = Math.max(left, Math.max(right, Math.max(up, down)));
        grid[i][j] = temp;
        return grid[i][j] + max;
    }
}
