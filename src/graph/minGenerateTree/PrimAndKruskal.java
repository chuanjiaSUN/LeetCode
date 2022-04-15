package graph.minGenerateTree;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-28 14:23
 */
public class PrimAndKruskal {

    /**leetCode1584 Prim*/
    public int minCostConnectPointsPrim(int[][] points) {
        int n = points.length;
        int res = 0;
        List<int[]>[] graph = buildGraph(points);

        Prim prim = new Prim(graph);
        return prim.getWeigh();
    }

    class Prim{
        List<int[]>[] graph;
        PriorityQueue<int[]> queue;
        boolean[] inMST;
        int weightSum = 0;

        public Prim(List<int[]>[] graph){
            int n = graph.length;
            this.graph = graph;
            this.queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
            inMST = new boolean[n];
            inMST[0] = true;
            cut(0);

            while (!queue.isEmpty()){
                int[] edge = queue.poll();
                int to = edge[1];
                int weight = edge[2];
                if (inMST[to]){
                    continue;
                }
                weightSum += weight;
                inMST[to] = true;
                cut(to);
            }
        }

        private void cut(int start) {
            for (int[] edge : graph[start]){
                int v = edge[0];
                int w = edge[1];
                int weight = edge[2];
                if (inMST[w]){
                    continue;
                }
                queue.offer(new int[]{v, w, weight});
            }
        }

        boolean isAllConnected(){
            for (boolean in : inMST){
                if (!in){
                    return false;
                }
            }
            return true;
        }

        int getWeigh(){
            return this.weightSum;
        }




    }

    private List<int[]>[] buildGraph(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);

                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }

        return graph;
    }

    /**Kruskal*/
    public int minCostConnectPointsKruskal(int[][] points) {
        int n = points.length;
        DisjointSetUnion dsu = new DisjointSetUnion(n);
        List<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });

        int ret = 0, num = 1;
        for (Edge edge : edges){
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)){
                ret += len;
                num++;
                if (num == n){
                    break;
                }
            }
        }

        return ret;
    }

    private int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    class DisjointSetUnion{
        int[] parent;
        int[] rank;
        int n;

        public DisjointSetUnion(int n){
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank, 1);
            this.parent = new int[n];
            for (int i = 0; i < n; i++){
                this.parent[i] = i;
            }
        }

        public int find(int x){
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public boolean unionSet(int x, int y){
            int fx = find(x), fy = find(y);
            if (fx == fy){
                return false;
            }
            if (rank[fx] < rank[fy]){
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            parent[fy] = fx;
            return true;
        }
    }

    class Edge{
        int len, x, y;

        public Edge(int len, int x, int y){
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
}
