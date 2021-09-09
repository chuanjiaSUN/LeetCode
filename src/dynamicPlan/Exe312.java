package dynamicPlan;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-09 10:12
 */
public class Exe312 {
    /**记忆化搜索*/
    int[][] rec;
    int[] val;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for (int i = 1; i <= n; i++)
        {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for (int i = 0; i <= n + 1; i++)
        {
            Arrays.fill(rec[i], -1);
        }
        return solve(0, n + 1);
    }

    private int solve(int left, int right) {
        if (left >= right - 1)
        {
            return 0;
        }
        if (rec[left][right] != -1)
        {
            return rec[left][right];
        }
        for (int i = left + 1; i < right; i++)
        {
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }
    /**动态规划*/
    public int maxCoins1(int[] nums)
    {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++)
        {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = i + 2; j <= n + 1; j++)
            {
                for (int k = i + 1; k < j; k++)
                {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(sum, rec[i][j]);
                }
            }
        }
        return rec[0][n + 1];
    }

}
