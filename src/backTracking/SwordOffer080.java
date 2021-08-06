package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-04 22:29
 */
public class SwordOffer080 {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] used;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[n + 1];
        backTrack(n, k, 0, 1);
        return ans;
    }

    private void backTrack(int n, int k, int count, int index) {
        if (count == k)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i <= n; i++)
        {
                path.add(i);
                backTrack(n, k, count + 1, i + 1);
                path.remove(path.size() - 1);
        }
    }
}
