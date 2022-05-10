package Interview;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-05-10 19:04
 */
public class TrapRain3DLeetCode407 {
    /**优先队列*/
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2){
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    queue.offer(new int[]{i * n + j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int res = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++){
                int nx = cur[0] / n + dirs[k];
                int ny = cur[1] % n + dirs[k + 1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    if (cur[1] > heightMap[nx][ny]){
                        res += cur[1] - heightMap[nx][ny];
                    }
                    queue.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], cur[1])});
                    visited[nx][ny] = true;
                }
            }
        }
        return res;
    }

    /**BFS*/
    public int bFStrapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        int[][] water = new int[m][n];

        int maxHigh = 0;
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                maxHigh = Math.max(maxHigh, heightMap[i][j]);
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                water[i][j] = maxHigh;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    if (water[i][j] > heightMap[i][j]){
                        water[i][j] = heightMap[i][j];
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }

        while (!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++){
                int nx = curr[0] + dirs[i];
                int ny = curr[1] + dirs[i + 1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n){
                    continue;
                }
                if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]){
                    water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                res += water[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}
