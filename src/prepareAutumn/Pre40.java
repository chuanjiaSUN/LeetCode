package prepareAutumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-02 22:18
 */
public class Pre40 {
    List<List<Integer>> ans;
    boolean[] visted;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        visted = new boolean[candidates.length];
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        travel(candidates, 0, target, path);
        return ans;
    }

    private void travel(int[] candidates, int index, int target, List<Integer> path) {
        if (target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++){
            if(target - candidates[i] < 0){
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]){
                continue;
            }
                path.add(candidates[i]);
                travel(candidates, i + 1, target - candidates[i], path);
                path.remove(path.size() - 1);

        }
    }
}
