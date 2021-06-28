package backTracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-28 12:40
 */
public class Exercise491 {
    List<List<Integer>> ans;
    List<Integer> path;
    static final int LOWER_COUNT = 2;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (nums == null || nums.length < LOWER_COUNT)
        {
            return ans;
        }
        backTrack(nums, 0, nums.length, Integer.MIN_VALUE);
        return ans;
    }

    private void backTrack(int[] nums, int index, int length, int last) {
        if (index == length)
        {
            //格式优化
            if (path.size() >= LOWER_COUNT)
            {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (nums[index] >= last)
        {
            path.add(nums[index]);
            backTrack(nums, index + 1, length, nums[index]);
            path.remove(path.size() - 1);
        }
        //去重
        if (nums[index] != last)
        {
            backTrack(nums, index + 1, length, last);
        }
    }
}
