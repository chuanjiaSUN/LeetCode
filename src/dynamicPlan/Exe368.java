package dynamicPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-10 10:08
 */
public class Exe368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[i] % nums[j] == 0)
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize)
            {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (maxSize == 1)
        {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = len - 1; i >= 0 && maxSize > 0; i--)
        {
            if (dp[i] == maxSize && maxVal % nums[i] == 0)
            {
                ans.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return ans;
    }
    public List<Integer> largestDivisibleSubset1(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        //记录最长长度与下标
        int[] f = new int[n];
        //记录由哪个状态转移过来
        int[] g = new int[n];
        for (int i = 0; i < n; i++)
        {
            int len = 1, prev = i;
            for (int j = 0; j < i; j++)
            {
                if (nums[i] % nums[j] == 0)
                {
                    if (f[j] + 1 > len)
                    {
                        len = f[j] + 1;
                        prev = j;
                    }
                }
            }
            f[i] = len;
            g[i] = prev;
        }

        int max = -1, idx = -1;
        for (int i = 0; i < n; i++)
        {
            if (f[i] > max)
            {
                idx = i;
                max = f[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (ans.size() != max)
        {
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}
