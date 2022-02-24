package num100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-23 15:33
 */
public class Exe78 {
    boolean[] used;
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        used = new boolean[len];
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) {
            return ans;
        }
        backTrack(ans, new ArrayList<Integer>(), 0, len, nums);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, ArrayList<Integer> combination, int index, int len, int[] nums) {
        if (index == len){
            ans.add(new ArrayList<Integer>(combination));
            return;
        }
        backTrack(ans, combination, index + 1, len, nums);
        if (!used[index]){
            combination.add(nums[index]);
            used[index] = true;
            backTrack(ans, combination, index + 1, len, nums);
            used[index] = false;
            combination.remove(combination.size() - 1);
        }
    }
}
