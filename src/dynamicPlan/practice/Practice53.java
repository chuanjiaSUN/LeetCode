package dynamicPlan.practice;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 22:19
 */
public class Practice53 {
    public int maxSubArray(int[] nums)
    {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len; i++)
        {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    /**空间优化*/
    public int maxSubArray1(int[] nums)
    {
        int len = nums.length;
        int pre = nums[0], cur = 0;
        int ans = pre;
        for (int i = 1; i < len; i++)
        {
            cur = Math.max(pre + nums[i], nums[i]);
            pre = cur;
            ans = Math.max(cur, ans);
        }
        return ans;
    }

}
