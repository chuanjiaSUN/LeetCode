package dynamicPlan.practice;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 22:32
 */
public class Practice300 {
    public int lengthOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < len; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
