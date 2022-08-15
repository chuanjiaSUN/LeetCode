package prepareAutumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-04 23:19
 */
public class Pre47 {
    List<List<Integer>> ans;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        travel(nums, 0, path);
        return ans;
    }

    private void travel(int[] nums, int index, List<Integer> path) {
        if (index == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            if (!used[i]){
                used[i] = true;
                path.add(nums[i]);
                travel(nums, index + 1, path);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}
