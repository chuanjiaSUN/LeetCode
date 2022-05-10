package Interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-05-10 14:37
 */
public class TopoLeetCode210 {
    List<List<Integer>> edges;
    int[] visited;
    int[] result;
    boolean valid = true;
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;

        for (int i = 0; i < numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        if (!valid){
            return new int[0];
        }
        return result;
    }

    private void dfs(int u) {
        visited[u] = 1;
        for(int v : edges.get(u)){
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
        visited[u] = 2;
        result[index--] = u;
    }

    int[] indeg;
    public int[] BfsfindOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        result = new int[numCourses];
        index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indeg[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int u = queue.poll();
            result[index++] = u;
            for (int v : edges.get(u)){
                indeg[v]--;
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return result;

    }
}
