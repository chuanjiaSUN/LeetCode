package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-22 14:40
 */
public class exercise47 {

    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return ans;
        Arrays.sort(nums);
        boolean[] visited = new boolean[len];
        dfs(nums, 0, len, visited);

        return ans;
    }

    private void dfs(int[] nums, int pos, int len, boolean[] visited) {
        if (pos == len)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++)
        {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
            {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, pos+1, len, visited);

            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
