package graph.topology;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-04-06 15:52
 */
public class ClassTable {

    /**
     * dfs方法
     */
    List<List<Integer>> edges;
    int[] visited;
    int[] result;
    boolean valid = true;
    int index;

    public int[] findOrder(int numClasses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numClasses; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numClasses];
        result = new int[numClasses];
        index = numClasses - 1;

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numClasses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (!valid) {
            return new int[0];
        }

        return result;
    }

    private void dfs(int pre) {
        visited[pre] = 1;
        for (int cur : edges.get(pre)) {
            if (visited[cur] == 0) {
                dfs(cur);
                if (!valid) {
                    return;
                }
            } else if (visited[cur] == 1) {
                valid = false;
                return;
            }
        }

        visited[pre] = 2;
        result[index--] = pre;
    }

    int[] indeg;

    /**
     * BFS方法
     */
    public int[] findOrderBFS(int numClasses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numClasses; i++) {
            edges.add(new ArrayList<>());
        }

        indeg = new int[numClasses];
        result = new int[numClasses];
        index = 0;

        for (int[] pair : prerequisites) {
            edges.get(pair[1]).add(pair[0]);
            indeg[pair[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numClasses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;

            for (int next : edges.get(cur)) {
                --indeg[next];
                if (indeg[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (index != numClasses) {
            return new int[0];
        }

        return result;
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> c1[1] - c2[1]);

        PriorityQueue<Integer> queue = new PriorityQueue<>((c1, c2) -> c2 - c1);
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                queue.offer(ti);
            } else if (!queue.isEmpty() && ti < queue.peek()) {
                total -= queue.poll() - ti;
                queue.offer(ti);
            }
        }

        return queue.size();
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] inverseAdj = new LinkedList[numCourses];
        Set<Integer>[] set = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i++) {
            inverseAdj[i] = new LinkedList<>();
            set[i] = new HashSet<>();
        }

        for (int[] pre : prerequisites){
            inverseAdj[pre[1]].add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++){
            if (!visited[i]){
                dfs1(i, inverseAdj, visited, set);
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries){
            int from = query[0];
            int to = query[1];
            ans.add(set[to].contains(from));
        }

        return ans;

    }

    private void dfs1(int cur, List<Integer>[] inverseAdj, boolean[] visited, Set<Integer>[] set) {
        visited[cur] = true;
        for (int i = 0; i < inverseAdj[cur].size(); i++){
            int pre = inverseAdj[cur].get(i);
            if (!visited[pre]){
                dfs1(pre, inverseAdj, visited, set);
            }
            set[cur].add(pre);
            set[cur].addAll(set[pre]);
        }
    }

}
