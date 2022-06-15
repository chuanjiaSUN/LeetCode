package prepareAutumn;

import java.util.ArrayList;
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
}
