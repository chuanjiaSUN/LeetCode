package prepareAutumn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-28 22:55
 */
public class Pre210 {
    List<List<Integer>> edges;
    int[] indeg;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] pre : prerequisites){
            edges.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        int[] ans = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (indeg[i] == 0){
                queue.offer(i);
                ans[index++] = i;
            }
        }
        while (!queue.isEmpty()){
            int u = queue.poll();
            for (int v : edges.get(u)){
                indeg[v]--;
                if (indeg[v] == 0){
                    ans[index++] = v;
                    queue.offer(v);
                }
            }
        }
        if (index == numCourses){
            return ans;
        }else{
            return new int[]{};
        }
    }

    int[] res;
    boolean valid = true;
    int[] visited;
    int index;
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
        }
        res = new int[numCourses];
        visited = new int[numCourses];
        index = numCourses - 1;
        for (int[] pre : prerequisites){
            edges.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        if (index == -1){
            return res;
        }
        return new int[]{};
    }

    private void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)){
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
        res[index--] = u;
    }

}
