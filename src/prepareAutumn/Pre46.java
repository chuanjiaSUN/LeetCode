package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-16 21:43
 */
public class Pre46 {
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == nums || nums.length == 0){
            return ans;
        }
        int len = nums.length;
        visited = new boolean[len];
        dfs(ans, new ArrayList<Integer>(), 0, len, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, ArrayList<Integer> integers, int index, int len, int[] nums) {
        if (integers.size() == len){
            ans.add(new ArrayList<>(integers));
        }
        if (index == len){
            return;
        }
        for (int i = 0; i < len; i++){
            if (!visited[i]){
                visited[i] = true;
                integers.add(nums[i]);
                dfs(ans, integers, index, len, nums);
                integers.remove(integers.size() - 1);
                visited[i] = false;
            }
        }
    }
    /**
     * practice
     * */
    boolean[] used;
    List<List<Integer>> res;
    public List<List<Integer>> permute1(int[] nums) {
        used = new boolean[nums.length];
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        travel(nums, 0, path);
        return res;
    }

    private void travel(int[] nums, int index, List<Integer> path) {
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                travel(nums, index, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
