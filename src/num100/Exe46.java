package num100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-20 15:09
 */
public class Exe46 {
    boolean[] used ;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        used = new boolean[nums.length];
        backTrack(nums,ans, path, 0);
        return ans;
    }

    private void backTrack(int[] nums, List<List<Integer>> ans, List<Integer> path, int index) {
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums, ans, path, i);
                path.remove(path.size() - 1);
            }
        }
    }
}
