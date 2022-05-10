package Interview;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-05-10 15:16
 */
public class TopoLeetCode1462 {
    List<List<Integer>> edges;
    int[] indeg;
    List<Set<Integer>> set;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        edges = new ArrayList<>();
        set = new ArrayList<>();
        for (int i = 0; i < numCourses; i++){
            edges.add(new ArrayList<>());
            set.add(new HashSet<>());
        }
        indeg = new int[numCourses];
        for (int[] edge : prerequisites){
            edges.get(edge[0]).add(edge[1]);
            indeg[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (indeg[i] == 0){
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()){
            int u = queue.poll();
            for (int v : edges.get(u)){
                indeg[v]--;
                set.get(v).add(u);
                set.get(v).addAll(set.get(u));
                if (indeg[v] == 0){
                    queue.offer(v);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        int index = 0;
        for (int[] info : queries){
            if (set.get(info[1]).contains(info[0])){
                result.add(true);
            }else{
                result.add(false);
            }
        }

        return result;
    }
}
