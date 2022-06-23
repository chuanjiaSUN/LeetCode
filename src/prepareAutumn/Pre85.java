package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-22 21:10
 */
public class Pre85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ? 1 : left[i][j - 1] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0'){
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--){
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, width * (i - k + 1));
                }
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    /**单调栈*/
    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){
                    left[i][j] = (j == 0 ? 1 : left[i][j - 1] + 1);
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < n; j++){
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < m; i++){
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i++){
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++){
                int high = down[i] - up[i] - 1;
                int area = high * left[i][j];
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}
