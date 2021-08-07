package backTracking;

import com.sun.prism.ReadbackRenderTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-07 14:21
 */
public class SwordOffer110 {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        Map<Integer, List<Integer>> line = new HashMap<>(50);
        int rows = graph.length;
        int cols = graph[0].length;
        for (int i = 0; i < rows; i++)
        {
            line.put(i, new ArrayList<>());
            for (int j = 0; j < graph[i].length; j++)
            {
                line.get(i).add(graph[i][j]);
            }
        }
        backTrack(line, rows, 0);
        return ans;
    }

    private void backTrack(Map<Integer, List<Integer>> line, int dst, int start) {
        if (start == dst)
        {
            ans.add(new ArrayList<>(path));
            ans.get(ans.size() - 1).add(start);
            return;
        }
        for (int nextDst : line.get(start))
        {
            if (!path.contains(nextDst))
            {
                path.add(start);
                backTrack(line, dst, nextDst);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 法2 不使用额外的hash表
     * */
    public List<List<Integer>> allPathsSourceTarget1(int[][] graph)
    {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        backTrack1(graph, graph.length,0);
        return ans;
    }

    private void backTrack1(int[][] graph, int length, int start) {
        if (start == length - 1)
        {
            path.add(start);
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(start);
        for (int i = 0; i < graph[start].length; i++)
        {
            if (!path.contains(graph[start][i]))
            {
                backTrack1(graph, length, graph[start][i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
