package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-22 15:37
 */
public class Exe688 {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        int[] dr = new int[]{2,2,1,1,-1,-1,-2,-2};
        int[] dc = new int[]{1,-1,2,-2,-2,2,1,-1};

        dp[row][column] = 1;
        for (; k >0;k--)
        {
            double[][] dp2 = new double[n][n];
            for (int r = 0; r < n; r++)
            {
                for (int c = 0; c < n; c++)
                {
                    for (int dir = 0; dir < 8; dir++)
                    {
                        int cr = r + dr[dir];
                        int cc = c + dc[dir];
                        if (0 <= cr && cr < n && 0 <=cc && cc < n)
                        {
                            dp2[cr][cc] += dp[r][c]/8;
                        }
                    }
                }
            }
            dp = dp2;
        }
        double ans = 0;
        for (double[] r:dp)
        {
            for (double x : r)
            {
                ans += x;
            }
        }
        return ans;
    }
}
