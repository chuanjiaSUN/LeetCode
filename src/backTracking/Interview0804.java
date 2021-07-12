package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-12 21:45
 */
public class Interview0804 {
    List<List<Integer>> ans;
    List<Integer> combine;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        combine = new ArrayList<>();
        deepSearch(nums, 0);
        return ans;
    }

    private void deepSearch(int[] nums, int index) {
        if (index == nums.length)
        {
            ans.add(new ArrayList<>(combine));
            return;
        }
        deepSearch(nums, index + 1);
        combine.add(nums[index]);
        deepSearch(nums, index + 1);
        combine.remove(combine.size() - 1);
    }
}
