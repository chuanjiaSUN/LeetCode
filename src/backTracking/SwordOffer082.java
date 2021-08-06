package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-04 23:35
 */
public class SwordOffer082 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        backTrack(candidates, target, 0, candidates.length);
        return ans;
    }

    private void backTrack(int[] candidates, int target, int index, int length) {
        if (target == 0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (index >= length)
        {
            return;
        }
        backTrack(candidates, target, index + 1, length);
        if (index > 0 && candidates[index] == candidates[index - 1] && !visited[index - 1])
        {
            return;
        }
        if (!visited[index] && target - candidates[index] >= 0)
        {
            visited[index] = true;
            path.add(candidates[index]);
            backTrack(candidates, target - candidates[index], index + 1, length);
            path.remove(path.size() - 1);
            visited[index] = false;
        }
    }
}
