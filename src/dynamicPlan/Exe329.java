package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-09 11:40
 */
public class Exe329 {
    int ans = 0;
    int rows, cols;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null)
        {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0)
        {
            return 0;
        }
        int[][] memo = new int[m][n];
        rows = m;
        cols = n;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int x, int y, int[][] path) {
       if (path[x][y] != 0)
       {
           return path[x][y];
       }
       ++path[x][y];
       for (int[] dir:directions)
       {
           int newX = x + dir[0], newY = y + dir[1];
           if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && matrix[newX][newY] > matrix[x][y])
           {
               path[x][y] = Math.max(path[x][y], dfs(matrix, newX, newY, path) + 1);
           }
       }
       return path[x][y];
    }
}
