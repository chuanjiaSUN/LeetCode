package num100;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-01 13:44
 */
public class Mian4 {

    private static int[][][] dp;
    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] matrix = new char[n][m];
        int sX = 0, sY = 0, eX = 0, eY = 0;
        for (int i = 0; i < n; i++){
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            for (int j = 0; j < m; j++){
                if (arr[j] == 'S'){
                    sX = i;
                    sY = j;
                }
                if (arr[j] == 'E'){
                    eX = i;
                    eY = j;
                }
                matrix[i][j] = arr[j];
            }
        }



        bfs(matrix, sX, sY, eX, eY);
        for (int i = 0; i < 6; i++){
            if (dp[eX][eY][i] != 0){
                System.out.println(dp[eX][eY][i]);
                return;
            }
        }
        System.out.println(-1);
    }

    private static void bfs(char[][] matrix, int sX, int sY, int eX, int eY) {
        Deque<int[]> queue = new ArrayDeque<>();
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n][6];

        queue.offer(new int[]{sX, sY, 0});

        while (!queue.isEmpty()){
            int[] status = queue.poll();

            int x = status[0], y = status[1], step = status[2];
            int nx = 0, ny = 0, nt = 0;
            for (int i = 0; i < 5; i++){
                if (i == 4){
                    nx = m - 1 - x;
                    ny = n - 1 - y;
                    nt = step + 1;
                }else{
                    nx = x + directions[i][0];
                    ny = y + directions[i][1];
                    nt = step;
                }
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && nt < 6 && matrix[nx][ny] != '#' && dp[nx][ny][nt] == 0){
                    dp[nx][ny][nt] = dp[x][y][step] + 1;
                    if (nx == eX && ny == eY){
                        return;
                    }
                    queue.offer(new int[]{nx, ny, nt});
                }
            }
        }
    }
}
