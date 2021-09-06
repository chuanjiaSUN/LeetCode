package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-06 11:05
 */
public class Exe198 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0)
        {
            return 0;
        }
        if (length == 1)
        {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++)
        {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
