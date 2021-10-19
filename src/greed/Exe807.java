package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-19 19:41
 */
public class Exe807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                rows[i] = Math.max(rows[i], grid[i][j]);
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                cols[i] = Math.max(cols[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int temp = Math.min(rows[j], cols[i]);
                if (grid[i][j] < temp)
                {
                    ans += (temp - grid[i][j]);
                }
            }
        }
        return ans;
    }
}
