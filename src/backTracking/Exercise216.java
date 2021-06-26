package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-26 10:17
 */
public class Exercise216 {
    /**运行速度击败百分百*/
    List<Integer> path = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static final int UP_BOUND = 9;
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, 0, k, n);
        return ans;
    }

    public void dfs(int start, int count, int k, int target)
    {
        if(count == k && target == 0)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || start > UP_BOUND || count > k)
        {
            return;
        }
        if(target - start >= 0)
        {
            dfs(start + 1, count, k, target);
            path.add(start);
            dfs(start + 1, count + 1, k, target - start);
            path.remove(path.size() - 1);
        }
    }
}
