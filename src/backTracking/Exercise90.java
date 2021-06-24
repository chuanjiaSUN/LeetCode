package backTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-24 13:26
 */
public class Exercise90 {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
        {
            return ans;
        }
        Arrays.sort(nums);
        backTrack(nums, 0, len, false);
        return ans;
    }

    private void backTrack(int[] nums, int start, int len, boolean choosePre) {
        if (start == len)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        backTrack(nums, start + 1, len, false);
        if (!choosePre && start > 0 && nums[start] == nums[start - 1])
        {
            return;
        }
        path.add(nums[start]);
        backTrack(nums, start + 1, len, true);
        path.remove(path.size() - 1);
    }
}
