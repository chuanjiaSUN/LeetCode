package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-20 16:40
 */
public class Exe53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int maxSubArray1(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums){
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
