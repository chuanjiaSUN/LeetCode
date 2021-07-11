package backTracking;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-11 14:40
 */
public class Exercise1863 {
    int res = 0;
    public int subsetXORSum(int[] nums) {
        if (nums.length == 1)
        {
            return nums[0];
        }
        dfs(nums, 0, 0);
        return res;
    }

    private void dfs(int[] nums, int i, int xorSum) {
        if (i == nums.length)
        {
            res += xorSum;
            return;
        }
        dfs(nums, i + 1, xorSum ^ nums[i]);
        dfs(nums, i + 1, xorSum);
    }
}
