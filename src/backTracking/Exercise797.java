package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-30 13:00
 */
public class Exercise797 {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (graph[0] == null)
        {
            return ans;
        }
        backTrack(graph, 0);
        return ans;
    }

    private void backTrack(int[][] graph, int start) {
        if (start == graph.length - 1)
        {
            path.add(start);
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(start);
        for (int i = 0; i < graph[start].length; i++)
        {
            backTrack(graph, graph[start][i]);
            path.remove(path.size() - 1);
        }
    }
}
