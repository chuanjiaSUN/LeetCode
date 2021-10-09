package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-09 10:45
 */
public class Exe45 {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len == 0)
        {
            return 0;
        }
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < len - 1; i++)
        {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end)
            {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    /**从后往前找出发位置*/
    public int jump1(int[] nums)
    {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0)
        {
            for (int i = 0 ; i < position; i++)
            {
                if (i + nums[i] >= position)
                {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**DP求解*/
    public int jump2(int[] nums)
    {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j <= nums[i] && i + j < len; j++)
            {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[len - 1];
    }

    /**动规2*/
    public int jump3(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1, j = 0; i  < n; i++)
        {
            while (j + nums[j] < i)
            {
                j++;
            }
            dp[i] = dp[j] + 1;
        }
        return dp[n - 1];
    }

}
