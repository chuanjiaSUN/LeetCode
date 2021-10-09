package greed;

import java.util.TreeSet;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-09 11:12
 */
public class Exe55 {
    /**贪心*/
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++)
        {
            if (i <= right)
            {
                right = Math.max(right, i + nums[i]);
                if (right >= n - 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**DP*/
    public boolean canJump1(int[] nums)
    {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n; i++)
        {
            if (dp[i])
            {
                for (int j = 1; j <= nums[i] && i + j < n; j++)
                {
                    dp[i + j] = true;
                }
            }
        }
        return dp[n - 1];
    }

    /**贪心*/
    public boolean canJump2(int[] nums)
    {
        int n = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < n; i++)
        {
            if (i <= maxPosition)
            {
                maxPosition= Math.max(maxPosition, i + nums[i]);
                if (maxPosition >= n - 1)
                {
                    return true;
                }
            }
        }

        return false;
    }

}
