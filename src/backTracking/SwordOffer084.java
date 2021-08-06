package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-06 22:58
 */
public class SwordOffer084 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTrack(nums, nums.length, 0);
        return ans;
    }

    private void backTrack(int[] nums, int length, int count) {
        if (count == length)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++)
        {
            if (!used[i])
            {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                backTrack(nums, length, count + 1);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
