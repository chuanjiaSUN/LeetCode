package num100;

import java.util.Scanner;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-01 21:33
 */
public class Mian8 {

    public static int mod = 10000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < m; k++){
                    matrix[j][k] = sc.nextInt();
                }
            }

            int ans = help(matrix);
            System.out.println(ans);
        }
    }

    private static int help(int[][] board) {
        int n = board.length, m = board[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int energy = board[i][j];
                for (int use = 1; use <= energy; use++){
                    for (int cost = 0; cost <= use; cost++){
                        int nx = i, ny = j;
                        nx += cost;
                        ny += use - cost;
                        if (nx >= n || ny >= m) continue;
                        dp[nx][ny] = (dp[nx][ny] + dp[i][j]) % mod;
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
