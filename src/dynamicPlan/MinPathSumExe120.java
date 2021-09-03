package dynamicPlan;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-03 10:08
 */
public class MinPathSumExe120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++)
        {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++)
            {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; i++)
        {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}