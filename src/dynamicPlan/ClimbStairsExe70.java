package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-02 15:07
 */
public class ClimbStairsExe70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**滚动数组*/
    public int climbStairs1(int n)
    {
        int pre = 0, last = 0, cur = 1;
        for (int i = 1; i <= n; i++)
        {
            pre = last;
            last = cur;
            cur = pre + last;
        }
        return cur;
    }
}
