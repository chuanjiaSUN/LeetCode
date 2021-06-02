package tree.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-02 10:48
 */
public class exercise834 {
    int[] ans;
    int[] sz;
    int[] dp;
    List<List<Integer>> graph;  //邻接表
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        sz = new int[n];
        dp = new int[n];
        graph = new ArrayList<>();//建立边的关系
        for (int i = 0; i < n; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges)
        {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs1(0, -1);
        return ans;
    }

    //求一个根节点的dp
    private void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v : graph.get(u))
        {
            if (v == f) continue;  //u,v无直接连接
            dfs(v, u);//找u的子节点v的dp
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    //交换根节点 求dp
    private void dfs1(int u, int f) {
        ans[u] = dp[u];
        for (int v : graph.get(u))
        {
            if (v == f) continue;
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            //开始交换结点
            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs1(v, u);  //更新其他结点

            dp[u] =  pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
}
