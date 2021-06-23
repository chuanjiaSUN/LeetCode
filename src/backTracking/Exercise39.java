package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-22 13:32
 */
public class Exercise39 {

    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, target, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, int pos) {
        if (pos == candidates.length) {
            return;
        }
        if (target == 0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(candidates, target, pos+1);
        if (target - candidates[pos] >= 0)
        {
            path.add(candidates[pos]);
            dfs(candidates, target - candidates[pos], pos);
            path.remove(path.size() - 1);
        }
    }


}
