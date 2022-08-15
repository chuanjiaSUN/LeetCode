package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-16 22:16
 */
public class Pre53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * practice
     * */
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        int max = 0;

        for (int i = 1; i <= len; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
