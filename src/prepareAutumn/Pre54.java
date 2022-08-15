package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-09 22:31
 */
public class Pre54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0, j = 0; i < m && j < n; i++, j++){
            int row = i;
            int col = j;
            if (!vis[row][col]){
                vis[row][col] = true;
                ans.add(matrix[row][col]);
            }
            while (col + 1< n && !vis[row][col + 1]){
                vis[row][col + 1] = true;
                ans.add(matrix[row][col + 1]);
                col += 1;
            }
            while (row + 1 < m && !vis[row + 1][col]){
                vis[row + 1][col] = true;
                ans.add(matrix[row + 1][col]);
                row += 1;
            }
            while (col - 1 >= 0 && !vis[row][col - 1]){
                vis[row][col - 1] = true;
                ans.add(matrix[row][col - 1]);
                col -= 1;
            }
            while (row - 1 >= 0 && !vis[row - 1][col]){
                vis[row - 1][col] = true;
                ans.add(matrix[row - 1][col]);
                row -= 1;
            }
        }
        return ans;
    }
}
