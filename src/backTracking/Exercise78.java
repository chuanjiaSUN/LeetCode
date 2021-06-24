package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-24 10:43
 */
public class Exercise78 {
    List<List<Integer>> ans;
    List<Integer> combine;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        combine = new ArrayList<>();
        backTrack(nums, 0, nums.length);
        return ans;
    }

    private void backTrack(int[] nums, int start, int len) {
        if (start == len)
        {
            ans.add(new ArrayList<>(combine));
            return;
        }
        backTrack(nums, start + 1, len);
        combine.add(nums[start]);
        backTrack(nums, start + 1, len);
        combine.remove(combine.size() - 1);
    }
}
