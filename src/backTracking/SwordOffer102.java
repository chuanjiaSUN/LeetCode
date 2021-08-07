package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-07 14:07
 */
public class SwordOffer102 {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        backTrack(nums, nums.length, target, 0);
        return ans;
    }

    private void backTrack(int[] nums,int length, int target, int index) {
        if(length == index )
        {
            if (target == 0)
            {
                ans++;
            }
            return;
        }
        backTrack(nums, length, target - nums[index], index + 1);
        backTrack(nums, length, target + nums[index], index + 1);
    }
}
