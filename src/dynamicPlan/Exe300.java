package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-08 11:18
 */
public class Exe300 {
    /**动态规划*/
    public int lengthOfLIS(int[] nums) {
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
    /**贪心 + 二分查找*/
    public int lengthOfLIS1(int[] nums)
    {
        int len = nums.length;
        if (len <= 1)
        {
            return len;
        }
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;

        for (int i = 1; i < len; i++)
        {
            if (nums[i] > tail[end])
            {
                end++;
                tail[end] = nums[i];
            }else{
                int left = 0;
                int right = end;
                while (left < right)
                {
                    int mid = left + (right - left) /2 ;
                    if (tail[mid] < nums[i])
                    {
                        left  = mid  + 1;
                    }else{
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }
        }
        end++;
        return end;
    }
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
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for(int i = 1; i <n; i++)
        {
            if (nums[i] > d[len])
            {
                d[++len] = nums[i];
            }else{
                int left = 1;
                int right = len;
                int pos = 0;
                while (left <= right)
                {
                    int mid = (left + right) >> 1;
                    if (d[mid] < nums[i])
                    {
                        pos = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
