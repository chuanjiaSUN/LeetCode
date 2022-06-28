package prepareAutumn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-28 22:35
 */
public class Pre207 {
    /**DFS*/
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < prerequisites.length; i++){
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] pre : prerequisites){
            edges.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        return valid;
    }

    private void dfs(int i) {
        visited[i] = 1;
        for (int v : edges.get(i)){
            if (visited[v] == 0){
                dfs(v);
                if (!valid){
                    return;
                }
            }else if (visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[i] = 2;
    }

    /**BFS*/
    int[] indeg;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] pre : prerequisites){
            edges.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (indeg[i] == 0){
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()){
            visited++;
            int u = queue.poll();
            for (int v : edges.get(u)){
                indeg[v]--;
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        return visited == numCourses;
    }
}
