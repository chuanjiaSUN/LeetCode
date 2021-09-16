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
    /**动规*/
    public int lengthOfLIS3(int[] nums)
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
        int[] f = new int[len];
        f[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < len; i++)
        {
            f[i] = 1;
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i])
                {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
                maxLen = Math.max(f[i], maxLen);
            }
        }
        return maxLen;
    }

    /**二分查找 + 贪心 优化*/
    public int lengthOfLIS4(int[] nums)
    {
        if (nums == null)
        {
            return 0;
        }
        int n = nums.length;
        if (n == 0)
        {
            return 0;
        }
        int[] f = new int[n + 1];
        int len = 1;
        f[len] = nums[0];
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > f[len])
            {
                f[++len] = nums[i];
            }else{
                int l = 1, r = len, pos = 0;
                while (l <= r)
                {
                    int mid = l + (r - l)/2;
                    if (f[mid] < nums[i])
                    {
                        pos = mid;
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                f[pos + 1] = nums[i];
            }
        }
        return len;
    }

}
