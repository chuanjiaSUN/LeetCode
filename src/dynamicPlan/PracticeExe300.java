package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-10 10:42
 */
public class PracticeExe300 {
    public int lengthOfLIS(int[] nums)
    {
        if (nums == null)
        {
            return 0;
        }
        int len = nums.length;
        if (len == 0)
        {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++)
        {
            dp[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] > nums[j])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**二分 + 贪心*/
    public int lengthOfLIS2(int[] nums)
    {
        if (nums == null)
        {
            return 0;
        }
        int len = 1, n = nums.length;
        if (n == 0)
        {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[len] = nums[0];
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > dp[len])
            {
                dp[++len] = nums[i];
            }else{
                int left = 1;
                int right = len;
                int pos = 0;
                while (left <= right)
                {
                    int mid = (left + right) >> 1;
                    if (dp[mid] < nums[i])
                    {
                        left = mid + 1;
                        pos = mid;
                    }else{
                        right = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
