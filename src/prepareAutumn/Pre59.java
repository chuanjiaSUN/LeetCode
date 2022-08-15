package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-11 22:23
 */
public class Pre59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        int num = 1;
        for (int x = 0, y = 0; x < n && y < n; x++, y++){
            int row = x;
            int col = y;
            if (!vis[row][col]){
                matrix[row][col] = num;
                vis[row][col] = true;
                num++;
            }
            while (col + 1 < n && !vis[row][col + 1]){
                matrix[row][col + 1] = num;
                vis[row][col + 1] = true;
                num++;
            }
            while (row + 1 < n && !vis[row + 1][col]){
                matrix[row + 1][col] = num;
                vis[row + 1][col] = true;
                num++;
            }
            while (col - 1 >= 0 && !vis[row][col - 1]){
                matrix[row][col - 1] = num;
                num++;
                vis[row][col - 1] = true;
            }
            while (row - 1 >= 0 && !vis[row - 1][col]){
                matrix[row - 1][col] = num;
                num++;
                vis[row - 1][col] = true;
            }
        }
        return matrix;
    }
}
