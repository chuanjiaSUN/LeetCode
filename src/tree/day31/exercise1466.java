package tree.day31;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-13 10:45
 */
public class exercise1466 {

    public int minReorder(int n, int[][] connections) {
        //构建连通图
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        for (int[] conn : connections)
        {
            Set<Integer> set = indexMap.containsKey(conn[0]) ? indexMap.get(conn[0]) : new HashSet<>();
            set.add(conn[1]);
            indexMap.put(conn[0], set);
            Set<Integer> setReverse = indexMap.containsKey(conn[1]) ? indexMap.get(conn[1]) : new HashSet<>();
            setReverse.add(conn[0] * -1);
            indexMap.put(conn[1], setReverse);
        }

        return bfs(indexMap, n);
    }

    private int bfs(Map<Integer, Set<Integer>> indexMap, int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty())
        {
            for (Integer node : indexMap.get(queue.poll()))
            {
               if (visited[Math.abs(node)]) continue;
               if (node > 0) ans++;
               visited[Math.abs(node)] = true;
               queue.offer(Math.abs(node));
            }
        }
        return ans;
    }

    //一次遍历
    public int minReorder1(int n, int[][] connections)
    {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int i = 0; i < connections.length; i++)
        {
            tree.get(connections[i][0]).add(i);
            tree.get(connections[i][1]).add(i);
        }

        boolean[] visited = new boolean[connections.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int ans = 0;

        while (!queue.isEmpty())
        {
            int node = queue.poll();
            List<Integer> connection = tree.get(node);
            for (Integer city : connection)
            {
                if (!visited[city])
                {
                    visited[city] = true;
                    int a = connections[city][0];
                    int b = connections[city][1];
                    ans += a == city ? 1 : 0;
                    queue.offer(a == city ? b : a);
                }
            }
        }
        return ans;
    }

}
