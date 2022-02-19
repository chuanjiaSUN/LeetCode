package num100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-19 23:40
 */
public class Exe39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0){
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        backTrack(ans, path, candidates, 0, target, candidates.length);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, List<Integer> path, int[] candidates, int idx, int target, int len) {
        if (target < 0){
            return;
        }
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < len; i++){
            path.add(candidates[i]);
            backTrack(ans, path, candidates, idx, target - candidates[i], len);
            path.remove(path.size() - 1);
        }
    }
}
