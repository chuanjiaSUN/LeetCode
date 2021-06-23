package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-23 13:01
 */
public class Exercise77 {
    List<List<Integer>> ans;
    boolean[] visited;
    List<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        visited = new boolean[n + 1];
        backTrack(n, k, visited, 0, 1);
        return ans;
    }

    private void backTrack(int n, int k, boolean[] visited, int count, int index) {
        if (count == k)
        {
            ans.add(new ArrayList<>(path));
        }else{
            for (int i = index; i <= n; i++)
            {
                if (!visited[i])
                {
                    path.add(i);
                    visited[i] = true;
                    backTrack(n, k, visited, count + 1, i + 1);
                    path.remove(path.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    /**法2
     * 剪枝 + 回溯
     * */
    public List<List<Integer>> combine1(int n, int k)
    {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(n, k, 1);
        return ans;
    }

    private void dfs(int n, int k, int cur) {
        if (path.size() + (n - cur + 1) < k)
        {
            return;
        }
        if (path.size() == k)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(cur);
        dfs(n, k, cur + 1);
        path.remove(path.size() - 1);
        dfs(n, k, cur + 1);
    }

    /**法3
     * 搜索
     *  剪枝不够彻底
     * */
    public List<List<Integer>> combine2(int n, int k)
    {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (k <= 0 || k > n)
        {
            return ans;
        }
        track(n, k, 1);
        return ans;
    }

    private void track(int n, int k, int begin) {
        if (path.size() == k)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++)
        {
            path.add(i);
            track(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    /**法4
     * 搜索的优化，判断搜索的上界
     * */
    public List<List<Integer>> combine3(int n, int k)
    {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (n < k || k <= 0)
        {
            return ans;
        }
        dfs1(1, n, k);
        return ans;
    }

    private void dfs1(int start, int n, int k) {
        if (path.size() + ( n - start + 1) < k)
        {
            return;
        }
        if (path.size() == k)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++)
        {
            path.add(i);
            dfs1(i + 1, n, k);
            path.remove(path.size() - 1);
        }
    }
}
