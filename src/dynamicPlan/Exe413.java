package dynamicPlan;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-14 13:12
 */
public class Exe413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1)
        {
            return 0;
        }
        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        for (int i = 2; i < n; i++)
        {
            if (nums[i - 1] - nums[i] == d)
            {
                ++t;
            }else{
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans +=t;
        }
        return ans;
    }
    /**双指针*/
    public int numberOfArithmeticSlices1(int[] nums)
    {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len - 2; i++)
        {
            int d = nums[i + 1] - nums[i];
            for (int j = i + 1; j < len - 1; j++)
            {
                if (nums[j + 1] - nums[j] == d)
                {
                    res++;
                }else{
                    break;
                }
            }
        }
        return res;
    }
    public int numberOfArithmeticSlices2(int[] nums)
    {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++)
        {
            int j = i, d= nums[i + 1] - nums[i];
            while (j + 1 < n && nums[j + 1] - nums[j] == d)
            {
                j++;
            }
            int len = j - i + 1;
            int a1 = 1, an = len - 3 + 1;
            int cnt = (a1 + an) * an / 2;
            ans += cnt;
            i = j;
        }
        return ans;
    }
    /**动态规划*/
    public int numberOfArithmeticSlices3(int[] nums)
    {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++)
        {
            if (nums[i + 1] + nums[i - 1] == nums[i])
            {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int d : dp)
        {
            ans += d;
        }
        return ans;
    }
    /**动规状态压缩*/
    public int numberOfArithmeticSlices4(int[] nums)
    {
        int len = nums.length;
        int ans = 0;
        int dp1 = 0;
        for (int i = 1; i < len -1; i++)
        {
            if (nums[i - 1] + nums[i + 1] == 2 * nums[i]){
                dp1++;
                ans += dp1;
            }else{
                dp1 = 0;
            }
        }
        return ans;
    }
    /**递归*/
    int res = 0;
    public int numberOfArithmeticSlices5(int[] nums)
    {
        int len = nums.length;
        dfs(nums,len - 1);
        return res;
    }

    private int dfs(int[] nums, int end) {
        if (end < 2)
        {
            return 0;
        }
        int temp = 0;
        if (nums[end] - nums[end - 1] == nums[end - 1] - nums[end - 2])
        {
            temp += dfs(nums, end - 1) + 1;
            res += temp;
        }else{
            dfs(nums, end - 1);
        }
        return temp;
    }
}
