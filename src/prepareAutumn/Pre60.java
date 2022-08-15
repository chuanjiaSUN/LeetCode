package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-15 21:52
 */
public class Pre60 {
    boolean[] vis;
    List<List<Integer>> ans = new ArrayList<>();
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        vis = new boolean[n + 1];
        vis[0] = true;
        dfs(n, list, 0);
        StringBuffer sb = new StringBuffer();
        List<Integer> integer = ans.get(k - 1);
        for (int num : integer){
            sb.append(num);
        }
        return sb.toString();
    }

    private void dfs(int n, List<Integer> list, int count) {
        if (count == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i <= n; i++){
            if (!vis[i]){
                vis[i] = true;
                list.add(i);
                dfs(n, list, count + 1);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
    }
}
