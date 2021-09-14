package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-14 10:51
 */
public class Exe397 {
    /**递归*/
    public int integerReplacement(int n) {
        long num = n;
        return dfs(num, 0);
    }

    private int dfs(long num, int count) {
        if (num == 1)
        {
            return count;
        }else if (num % 2 == 0)
        {
            return dfs(num / 2, count + 1);
        }else{
            return Math.min(dfs(num + 1, count + 1), dfs(num - 1, count + 1));
        }
    }
    /**动规*/
    public int integerReplacement1(int n)
    {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++)
        {
            if (i % 2 == 0)
            {
                dp[i] = dp[i % 2] + 1;
            }else{
                dp[i] = Math.min(dp[i- 1], dp[(i + 1)/ 2] + 1) + 1;
            }
        }
        return dp[n];
    }
}
