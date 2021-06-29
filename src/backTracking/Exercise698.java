package backTracking;


import Arrays.day24.TanXin_exe621;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-29 14:32
 */
public class Exercise698 {

    boolean[] visited;
    int count;
    public boolean canPartitionToSubSets(int[] nums, int k) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        int ave = sum / k;
        if (sum % k != 0)
        {
            return false;
        }
        if (nums[nums.length - 1] > ave)
        {
            return false;
        }
        return backTrack(nums, k, nums.length - 1, ave, 0);

    }

    private boolean backTrack(int[] nums, int k, int begin, int target, int last) {
       if (k == 1)
       {
           return true;
       }
       if (last == target)
       {
           return backTrack(nums, k - 1, nums.length - 1, target, 0);
       }
       for (int i = begin; i >= 0; i--)
       {
           if (visited[i])
           {
               continue;
           }
           if (last + nums[i] > target)
           {
               continue;
           }
           visited[i] = true;
           if (backTrack(nums, k, i - 1, target, last + nums[i]))
           {
               return true;
           }
           visited[i] = false;

           while (i > 0 && nums[i - 1] == nums[i])
           {
               i--;
           }
       }
       return false;
    }
}
