package dynamicPlan;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-25 20:11
 */
public class Exe787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] f = new int[k + 2][n];
        final int INF = 10000 * 101 + 1;
        for (int i = 0; i < k + 2; i++)
        {
            Arrays.fill(f[i], INF);
        }
        f[0][src] = 0;
        for (int t = 1; t <= k + 1; k++)
        {
            for (int [] flight : flights)
            {
                int j = flight[0];
                int i = flight[1], cost = flight[2];
                f[t][i] = Math.min(f[t][i], f[t - 1][j] + cost);
            }
        }
        int ans = INF;
        for (int t = 1; t <= k + 1; t++)
        {
            ans = Math.min(ans, f[t][dst]);
        }
        return ans;
    }
    /**空间优化*/
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k)
    {
        final int INF = 10000* 101 + 1 ;
        int[] f = new int[n];
        Arrays.fill(f, INF);
        f[src] = 0;
        int ans = INF;
        for (int t = 1; t <= k + 1; t++)
        {
            int[] g = new int[n];
            Arrays.fill(g, INF);
            for (int[] flight : flights)
            {
                int i = flight[0], j = flight[1], cost = flight[2];
                g[j] = Math.min(g[j], f[i] + cost);
            }
            f = g;
            ans = Math.min(ans, f[dst]);
        }
        return ans == INF ? -1 : ans;
    }

    /**记忆化搜索*/
    final int INF = 1000007;
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k)
    {
        int[][] memo = new int[n][k + 2];
        int ans = dfs(flights, src, dst, k + 1, memo);
        return ans >= INF ? -1 : ans;
    }

    private int dfs(int[][] flights, int i, int dst, int k, int[][] memo) {
        if (k < 0)
        {
            return INF;
        }
        if (i == dst)
        {
            return 0;
        }
        if (memo[i][k] != 0)
        {
            return memo[i][k];
        }
        int min = INF;
        for (int[] flight : flights)
        {
            if (flight[0] == i)
            {
                min = Math.min(min, dfs(flights, flight[1], dst, k - 1, memo) + flight[2]);
            }
        }
        memo[i][k] = min;
        return min;
    }
    /**BFS*/
    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int k)
    {
        return bfs(n, flights, src, dst, k);
    }

    private int bfs(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++)
        {
            g[i] = new ArrayList<>();
        }

        for (int[] flight : flights)
        {
            g[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty() && k + 1 > 0)
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                int[] poll = queue.poll();
                for (int[] path : g[poll[0]])
                {
                    int distance = poll[1] + path[1];
                    if (distance < ans[path[0]] && distance < ans[dst])
                    {
                        ans[path[0]] = distance;
                        if (path[0] != dst)
                        {
                            queue.offer(new int[]{path[0], distance});
                        }
                    }
                }
            }
            k--;
        }
        return ans[dst] >= INF ? -1 : ans[dst];
    }

}
