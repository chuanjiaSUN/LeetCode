package Interview;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-05-10 14:09
 */
public class TopologyLeetCode207 {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];

        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
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

    int[] indeg;
    public boolean bfsCanFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[1]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
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
                --indeg[v];
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }
}
