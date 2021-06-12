package tree.day30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-12 12:00
 */
public class exercise1443 {
    int[] reverseEdges;
    int ans = 0;
    boolean[] visited;
    public void buildReverseEdges(List<List<Integer>> nodeMap, int val)
    {
        for (int pairVal : nodeMap.get(val))
        {
            if (pairVal != 0 && reverseEdges[pairVal] == -1)
            {
                reverseEdges[pairVal] = val;
                buildReverseEdges(nodeMap, pairVal);
            }
        }
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> nodeMap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeMap.add(new ArrayList<>());
        }
        for (int[] edge : edges)
        {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }
        reverseEdges = new int[n];//用来存储父节点信息
        Arrays.fill(reverseEdges, -1);
        buildReverseEdges(nodeMap, 0);//建立以 0 为根节点的树
        visited = new boolean[n];
        visited[0] = true;

        for (int i = 0; i < n; i++)
        {
            if (hasApple.get(i))
            {
                dfsEdge(i);
            }
        }
        return ans * 2;
    }

    private void dfsEdge(int i) {
        if (!visited[i])
        {
            visited[i] = true;
            ans++;
            dfsEdge(reverseEdges[i]);
        }
    }
    //法2 使用数组存储节点, 但只能处理只有一个父节点的情况
    int result = 0;
    public int minTime1(int n, int[][] edges, List<Boolean> hasApple)
    {
        if (hasApple.size() <= 1) return 0;
        visited = new boolean[hasApple.size()];
        int[] parent = new int[n];//存储父节点

        for (int[] edge : edges) {
            parent[edge[1]] = edge[0];
        }

        for (int i = 0; i < hasApple.size(); i++) {
            if (hasApple.get(i)) {
                dfs(i, parent);
            }
        }
        return result << 1;
    }

    private void dfs(int son, int[] parent) {
        if (son == 0 || visited[son]) return;
        result++;
        visited[son] = true;
        dfs(parent[son], parent);
    }
}
