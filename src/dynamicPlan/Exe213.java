package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-06 11:13
 */
public class Exe213 {
    int[] nums;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        int length = nums.length;
        if (length == 1)
        {
            return nums[0];
        }else if (length == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        this.nums = nums;
        return Math.max(robRange(0, length - 2), robRange(1, length - 1));
    }
    private int robRange1(int start, int end){
        int len = nums.length;
        int[] dp = new int[len];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++)
        {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
    private int robRange(int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++)
        {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
