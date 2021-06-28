package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-28 13:29
 */
public class Exercise494 {
    int ans;
    int len;
    public int findTargetSumWays(int[] nums, int target) {
        len = nums.length;
        backTrack(nums, target, 0);
        return ans;
    }

    private void backTrack(int[] nums, int target, int index) {
        if (index == len)
        {
            if (target == 0)
            {
                ans++;
            }
            return;
        }
        backTrack(nums, target + nums[index], index + 1);
        backTrack(nums, target - nums[index], index + 1);
    }
}
