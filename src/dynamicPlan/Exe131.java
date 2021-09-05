package dynamicPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-05 10:33
 */
public class Exe131 {
    boolean[][] f;
    List<String> path = new ArrayList<>();
    List<List<String>> ans = new ArrayList<>();
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = i + 1; j < n; j++)
            {
                f[i][j] = (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1]);
            }
        }
        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int index) {
        if (index == n)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = index; j < n; j++)
        {
            if (f[index][j])
            {
                path.add(s.substring(index, j + 1));
                dfs(s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
