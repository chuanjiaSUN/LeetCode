package graph.minGenerateTree.shortDistance;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-28 16:21
 */
public class FloydAndDijkstraAndBellman {

    /**
     * Floyd leetCode 1334
     */
    public int findTheCityFloyd(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
            distances[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            distances[u][v] = w;
            distances[v][u] = w;
        }

        floyd(distances, n);

        int idx = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (distances[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                idx = i;
            }
        }

        return idx;
    }

    public void floyd(int[][] distances, int n) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE && distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }
    }

    /**
     * Dijkstra
     */
    public int findTheCityDijkstra(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        int idx = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            boolean[] visited = new boolean[n];
            Dijkstra(graph, distances, visited, i, distanceThreshold, n);

            int count = 0;

            for (int j = 0; j < n; j++) {
                if (distances[j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count <= minCount) {
                minCount = count;
                idx = i;
            }
        }
        return idx;
    }

    private void Dijkstra(int[][] graph, int[] distances, boolean[] visited, int start, int distanceThreshold, int n) {
        distances[start] = 0;
        for (int i = 0; i < n; i++) {
            int dst = -1, minDistance = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    dst = j;
                    minDistance = distances[j];
                }
            }
            if (dst == -1) {
                return;
            }
            visited[dst] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[dst][j] != Integer.MAX_VALUE) {
                    if (distances[dst] + graph[dst][j] < distances[j]) {
                        distances[j] = distances[dst] + graph[dst][j];
                    }
                }
            }

        }
    }


    /**
     * Bellman-Ford
     */
    public int findTheCityBellman(int n, int[][] edges, int distanceThreshold) {
        List<Edge> evec = new ArrayList<>();
        for (int[] edge : edges) {
            Edge e1, e2;
            e1 = new Edge(edge[0], edge[1], edge[2]);
            e2 = new Edge(edge[1], edge[0], edge[2]);
            evec.add(e1);
            evec.add(e2);
        }

        int idx = -1, minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            int[] distances = new int[n];
            Arrays.fill(distances, Integer.MAX_VALUE);
            BellmanFord(evec, distances, i, n);
            int count = 0;
            for (int j = 0; j < n; j++){
                if (distances[j] <= distanceThreshold && i != j){
                    count++;
                }
            }

            if (count <= minCount){
                minCount = count;
                idx = i;
            }
        }
        return idx;
    }

    private void BellmanFord(List<Edge> evec, int[] distances, int start, int n) {
        distances[start] = 0;
        for (Edge edge : evec){
            if (edge.from == start){
                distances[edge.to] = edge.weight;
            }
        }
        for (int i = 0; i < n - 1; i++){
            for (Edge edge : evec){
                if (distances[edge.from] != Integer.MAX_VALUE && distances[edge.to] > distances[edge.from] + edge.weight){
                    distances[edge.to] = distances[edge.from] + edge.weight;
                }
            }
        }

    }
    public int myAtoi(String str){
        int len = str.length();

        char[] arr = str.toCharArray();
        int index = 0;
        while(index < len && arr[index] == ' '){
            index++;
        }

        if (index == len){
            return 0;
        }
        int sign = 1;
        char firstChar = arr[index];
        if (firstChar == '+'){
            index++;
        }else if (firstChar == '-'){
            index++;
            sign = -1;
        }

        int res = 0;
        while (index < len){
            char curChar = arr[index];
            if (curChar > '9' || curChar < '0'){
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (curChar - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (curChar - '0') > -(Integer.MIN_VALUE % 10))){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (curChar - '0');
            index++;
        }
        return res;
    }

    class Edge {
        int from;
        int to;
        int weight;

        public Edge() {
        }

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
