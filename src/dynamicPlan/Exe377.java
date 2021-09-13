package dynamicPlan;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 10:51
 */
public class Exe377 {
    /**递归，超时*/
    int ans = 0;
    int len;
    public int combinationSum4(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        dfs(nums, 0, target);
        return ans;
    }

    private void dfs(int[] nums, int index, int target) {
        if (target == 0)
        {
            ans++;
            return;
        }
        if (target < 0 || index >= len)
        {
            return;
        }
        for (int i = 0; i < len; i++)
        {
            if (target - nums[i] >= 0)
            {
                dfs(nums, i, target - nums[i]);
            }
        }
    }
    /**动规*/
    public int combinationSum41(int[] nums, int target)
    {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int len = nums.length;
        for (int i = 1; i <= target; i++)
        {
            for (int num : nums)
            {
                if (num <= i)
                {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
