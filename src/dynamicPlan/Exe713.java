package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-23 10:49
 */
public class Exe713 {
    /**滑动窗口向左滑*/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k >= 1)
        {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        int right = n - 1;
        int prod = 1;
        for (int left = n - 1; left >= 0; left--)
        {
            prod *= nums[left];
            while (prod >= k)
            {
                prod /= nums[right];
                right--;
            }
            count += right - left + 1;
        }
        return count;
    }

    /**滑动窗口向右滑*/
    public int numSubarrayProductLessThanK1(int[] nums, int k)
    {
        if (k <= 1)
        {
            return 0;
        }
        int n = nums.length;
        int count = 0;
        int left = 0;
        int prod = 1;
        for (int right = 0; right < n; right++)
        {
            prod *= nums[right];
            while (prod >= k)
            {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

    /**暴力*/
    public int numSubarrayProductLessThanK2(int[] nums, int k)
    {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++)
        {
            int temp = 1;
            for (int j = i; j < len; j++)
            {
                temp *= nums[j];
                if (temp >= k)
                {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    /**二分查找*/
    public int numSubarrayProductLessThanK3(int[] nums, int k)
    {
        if (k == 0)
        {
            return 0;
        }
        double logk = Math.log(k);
        int len = nums.length;
        double[] prefix = new double[len + 1];
        for (int i = 0; i < len; i++)
        {
            prefix[i + 1] = prefix[i] + Math.log(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < len + 1; i++)
        {
            int lo = i + 1, high = len + 1;
            while (lo < high)
            {
                int mid = lo + ((high - lo)>> 1);
                if (prefix[mid] < prefix[i] + logk -1e-9)
                {
                    lo = mid + 1;
                }else{
                    high = mid;
                }
            }
            ans += lo - i - 1;
        }
        return ans;
    }
    /**双指针*/
    public int numSubarrayProductLessThanK4(int[] nums, int k)
    {
        if (k <= 1)
        {
            return 0;
        }
        int ans = 0;
        int len = nums.length;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < len; right++)
        {
            prod *= nums[right];
            while (prod >= k)
            {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }

}
