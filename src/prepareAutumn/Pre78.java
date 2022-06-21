package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-21 22:50
 */
public class Pre78 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0){
            return ans;
        }
        int len = nums.length;
        dfs(0, len, new ArrayList<Integer>(), nums);
        return ans;
    }

    private void dfs(int index, int len, ArrayList<Integer> integers, int[] nums) {
        if (index == len){
            ans.add(new ArrayList<>(integers));
            return;
        }
        dfs(index + 1, len, integers, nums);
        integers.add(nums[index]);
        dfs(index + 1, len, integers, nums);
        integers.remove(integers.size() - 1);
    }
}
