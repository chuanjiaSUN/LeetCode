package dynamicPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-22 14:17
 */
public class Exe673 {
    /**
     * 动规
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    /**
     * 贪心 + 二分查找 + 前缀和
     */
    public int findNumberOfLIS1(int[] nums) {
        List<List<Integer>> d = new ArrayList<>();
        List<List<Integer>> cnt = new ArrayList<>();
        for (int v : nums)
        {
            int i = binarySearch1(d.size(), d, v);
            int c = 1;
            if (i > 0)
            {
                int k = binarySearch2(d.get(i - 1).size(), d.get(i - 1), v);
                c = cnt.get(i - 1).get(cnt.get(i - 1).size() - 1) - cnt.get(i - 1).get(k);
            }
            if (i == d.size())
            {
                List<Integer> dList = new ArrayList<>();
                dList.add(v);
                d.add(dList);
                List<Integer> cntList = new ArrayList<>();
                cntList.add(0);
                cntList.add(c);
                cnt.add(cntList);
            }else{
                d.get(i).add(v);
                int cntSize = cnt.get(i).size();
                cnt.get(i).add(cnt.get(i).get(cntSize - 1) + c);
            }
        }
        int size1 = cnt.size(), size2 = cnt.get(size1 - 1).size();
        return cnt.get(size1 - 1).get(size2 - 1);
    }

    private int binarySearch2(int n, List<Integer> list, int target) {
        int l = 0, r = n;
        while (l < r)
        {
            int mid = (l + r) >> 1;
            if (list.get(mid) < target)
            {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private int binarySearch1(int n, List<List<Integer>> d, int target) {
        int l = 0, r = n;
        while (l < r)
        {
            int mid = (l + r) >> 1;
            List<Integer> list = d.get(mid);
            if (list.get(list.size() - 1) >= target)
            {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public int findNumberOfLIS4(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int maxLen = 0, ans = 0;
        for (int i = 0; i < n; i++)
        {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j <= i ;j++)
            {
                if (nums[j] < nums[i])
                {
                    if (dp[j] + 1 > dp[i])
                    {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if (dp[j] + 1 == dp[i])
                    {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (dp[i] > maxLen)
            {
                maxLen = dp[i];
                ans = cnt[i];
            }else if (dp[i] == maxLen){
                ans += cnt[i];
            }
        }
        return ans;
    }

}
