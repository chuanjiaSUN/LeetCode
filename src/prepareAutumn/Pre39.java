package prepareAutumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-15 22:13
 */
public class Pre39 {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        dfs(candidates, target, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> combinations, int i) {
        if (target == 0){
            ans.add(new ArrayList<>(combinations));
            return;
        }
        if (target < 0){
            return;
        }
        dfs(candidates, target, combinations, i + 1);
        if (target - candidates[i] >= 0){
            combinations.add(candidates[i]);
            dfs(candidates, target, combinations, i);
            combinations.remove(combinations.size() - 1);
        }
    }

    /**
     * practice
     * */

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        int len = candidates.length;
        List<Integer> path = new ArrayList<>();
        travel(candidates, 0, target, path);
        return ans;
    }

    private void travel(int[] candidates, int index, int target, List<Integer> path) {
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }
        path.add(candidates[index]);
        travel(candidates, index, target - candidates[index], path);
        path.remove(path.size() - 1);
        travel(candidates, index + 1, target, path);
    }
}
