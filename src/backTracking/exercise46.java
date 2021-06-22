package backTracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-22 14:12
 */
public class exercise46 {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        for (int num : nums)
        {
            path.add(num);
        }
        int n = nums.length;
        dfs(n, 0);
        return ans;
    }

    private void dfs(int n, int first) {
        if (first == n)
        {
            ans.add(new ArrayList<>(path));
        }
        for (int i = first; i < n; i++)
        {
            //动态维护数组
            Collections.swap(path, first, i);
            dfs(n, first + 1);
            Collections.swap(path, first, i);
        }
    }
    public List<List<Integer>> permute1(int[] nums)
    {
        int len = nums.length;
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (len == 0) return ans;
        boolean[] visited = new boolean[len];

        dfs1(nums, visited, len, 0);
        return ans;
    }

    private void dfs1(int[] nums, boolean[] visited, int len, int pos) {
        if (pos == len)
        {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++)
        {
            if (!visited[i])
            {
                path.add(nums[i]);
                visited[i] = true;

                dfs1(nums, visited, len, pos + 1);

                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
