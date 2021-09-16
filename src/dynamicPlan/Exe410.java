package dynamicPlan;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-15 11:27
 */
public class Exe410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
        {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++)
        {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= Math.min(i, m); j++)
            {
                for (int k = 0; k < i; k++)
                {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i]-sub[k]));
                }
            }
        }
        return f[n][m];
    }
    /**二分查找 + 贪心*/
    public int splitArray1(int[] nums, int m)
    {
        int left = 0, right = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++)
        {
            right += nums[i];
            if (left < nums[i])
            {
                left = nums[i];
            }
        }
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, m))
            {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int x, int m) {
        int sum = 0;
        int cnt = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++)
        {
            if(sum + nums[i] > x)
            {
                cnt++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

    /**二分查找，尽量让数组分出更多的子数组*/
    public int splitArray2(int[] nums, int m)
    {
        //定义二分查找的上下界
        int maxSum = 0, sum = 0;
        for (int num : nums)
        {
            maxSum = Math.max(maxSum, num);
            sum += num;
        }
        int left = maxSum;
        int right = sum;
        while (left < right)
        {
            int mid = left + ((right - left)>>1);
            int splitNum = split(nums, mid);
            if (splitNum > m)
            {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int split(int[] nums, int target) {
        int ans = 1;
        int currentSum = 0;
        for (int num : nums)
        {
            if (currentSum + num >  target)
            {
                ans++;
                currentSum  = 0;
            }
            currentSum += num;
        }
        return ans;
    }
}
