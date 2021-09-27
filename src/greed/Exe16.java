package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-27 11:46
 */
public class Exe16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
        {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int best = Integer.MAX_VALUE / 2;
        for (int first = 0; first < n; first++)
        {
            if (first > 0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            int l = first + 1;
            int r = n - 1;
            while (l < r)
            {
                int sum = nums[first] + nums[l] + nums[r];
                if (sum == target)
                {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(best - target))
                {
                    best = sum;
                }
                if (sum > target)
                {
                    int r0 = r - 1;
                    while (l < r0 && nums[r0] == nums[r])
                    {
                        r0--;
                    }
                    r = r0;
                }else{
                    int l0 = l + 1;
                    while (l0 < r && nums[l0] == nums[l])
                    {
                        l0++;
                    }
                    l = l0;
                }
            }
        }
        return best;
    }
}
