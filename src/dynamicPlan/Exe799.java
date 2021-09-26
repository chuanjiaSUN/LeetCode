package dynamicPlan;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-26 13:30
 */
public class Exe799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[100][100];
        dp[0][0] = (double) poured;
        for (int i = 1; i <= query_row; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                double next = (dp[i - 1][j] - 1.0)/2.0;
                if (next > 0)
                {
                    dp[i][j] += next;
                    dp[i][j + 1] += next;
                }
                if (i == query_row && j > query_glass)
                {
                    break;
                }
            }
        }
        return Math.min(dp[query_row][query_glass], 1.0);
    }
    /**滚动数组空间优化*/
    public double champagneTower2(int poured, int query_row, int query_glass)
    {
        double[] dp = new double[100];
        dp[0] = (double)poured;
        for (int i = 1; i <= query_row; i++)
        {
            double[] temp = new double[100];
            for (int j = 0; j < i; j++)
            {
                double overFlow = (dp[j] - 1.0) / 2.0;
                if (overFlow > 0)
                {
                    temp[j] += overFlow;
                    temp[j + 1] += overFlow;
                }
            }
            dp = temp;
            if (i == query_row)
            {
                break;
            }
        }
        return dp[query_glass] > 1.0 ? 1.0 : dp[query_glass];
    }
    public double champagneTower1(int poured, int query_row, int query_glass)
    {
       double[] dp = new double[100];
       dp[0] = (double)poured;
       for (int i = 1; i <= query_row; i++)
       {
           double overFlow = Math.max(0, dp[0] - 1.0);
           dp[0] = 0;
           double half;
           //当前行，一次更新一个位置
           for (int j = 0; j < i; j++)
           {
               half = overFlow / 2;
               dp[j] += half;
               overFlow = Math.max(0, dp[j + 1] - 1);
               dp[j + 1] = half;
           }
       }
       return dp[query_glass] > 1.0 ? 1.0 : dp[query_glass];
    }
}
