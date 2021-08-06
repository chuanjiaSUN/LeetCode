package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-04 22:05
 */
public class SwordOffer081 {
    List<List<Integer>> ans;
    List<Integer> path;
    int length;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        path = new ArrayList<>();
        length = candidates.length;
        backTrack(candidates, target, 0);
        return ans;
    }

    private void backTrack(int[] candidates, int target, int index) {
        if (target == 0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (index >= length)
        {
            return;
        }
        if (target >= 0)
        {
            path.add(candidates[index]);
            backTrack(candidates, target - candidates[index], index);
            path.remove(path.size() - 1);
        }
        backTrack(candidates, target, index + 1);
    }
}
