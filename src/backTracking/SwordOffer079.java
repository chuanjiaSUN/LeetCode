package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-04 22:17
 */
public class SwordOffer079 {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        backTrack(nums, 0, length);
        return ans;
    }

    private void backTrack(int[] nums, int index, int length) {
        if (index == length)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        backTrack(nums, index + 1, length);
        path.add(nums[index]);
        backTrack(nums, index + 1, length);
        path.remove(path.size() - 1);
    }
}
