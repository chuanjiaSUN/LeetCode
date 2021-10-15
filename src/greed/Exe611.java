package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-15 11:45
 */
public class Exe611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right)
                {
                    int mid = left + ((right - left) >> 1);
                    if (nums[mid] < nums[i] + nums[j])
                    {
                        k = mid;
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }

    public int triangleNumber1(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            int k = i;
            for (int j = i + 1; j < n; j++)
            {
                while (k + 1 < n && nums[k + 1] < nums[i] +  nums[j])
                {
                    k++;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }
}
