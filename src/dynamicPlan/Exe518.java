package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-18 15:24
 */
public class Exe518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++)
        {
           int val = coins[i - 1];
           for (int j = 0; j <= amount; j++)
           {
               //不使用该硬币
               f[i][j] = f[i - 1][j];
               //使用n次该硬币
               for (int k = 1; k * val <= j; k++)
               {
                   f[i][j] += f[i - 1][j - k * val];
               }
           }
        }
        return f[n][amount];
    }
    /**空间优化*/
    public int change1(int amount, int[] coins)
    {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++)
            {
                f[j] += f[j - val];
            }
        }
        return f[amount];
    }

}
