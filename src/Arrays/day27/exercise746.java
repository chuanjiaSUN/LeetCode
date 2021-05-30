package Arrays.day27;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-03 16:06
 */
public class exercise746 {
    //动态规划
    public int minCostClimbingStairs(int[] cost) {
       int length = cost.length;
       int[] dp = new int[length + 1];
       dp[0] = 0; dp[1] = 0;
       for( int i = 2; i <= length; i++)
       {
           dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i -2] + cost[i - 2]);
       }
       return dp[length];
    }
    //优化，不用数组存储
    public int minCostClimbingStairs1(int[] cost)
    {
        int length = cost.length;
        int pre = 0, next = 0;
        for( int i = 2; i <= length; i++)
        {
            int cur = Math.min(pre + cost[i - 2], next + cost[ i - 1]);
            pre = next;
            next = cur;
        }
        return next;
    }
}
