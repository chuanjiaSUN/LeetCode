package backtrackrevise;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-29 15:00
 */
public class Exe698 {
    private boolean[] visited;
    public boolean canPartitionSubSets(int[] nums, int k)
    {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }

        if (sum % k != 0)
        {
            return false;
        }

        int target = sum / k;
        if (nums[nums.length - 1] > target)
        {
            return false;
        }
        return backTrack(nums, nums.length - 1, k, target, 0);
    }

    private boolean backTrack(int[] nums, int start, int k, int target, int last) {
        if (k == 1)
        {
            return true;
        }
        if (last == target)
        {
            return backTrack(nums, nums.length - 1, k - 1, target, 0);
        }

        for (int i = start; i >= 0; i--)
        {
            if (!visited[i])
            {
                if (last + nums[i] > target)
                {
                    continue;
                }
                visited[i] = true;
                if (backTrack(nums, i - 1, k, target, last + nums[i]))
                {
                    return true;
                }
                visited[i] = false;

                if (i > 0 && nums[i] == nums[i - 1])
                {
                    i--;
                }
            }
        }
        return false;
    }
}
