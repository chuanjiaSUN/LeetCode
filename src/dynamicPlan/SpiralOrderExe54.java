package dynamicPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-02 14:37
 */
public class SpiralOrderExe54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m == 0 || n == 0)
        {
            return ans;
        }
        boolean[][] visited = new boolean[m][n];
        int total = m * n;
        int[][] direction = new int[][]{{0, 1}, {1, 0},{0, -1}, {-1, 0}};
        int index = 0;
        int x = 0, y = 0;
        for (int i = 0; i < total; i++)
        {
            ans.add(matrix[x][y]);
            visited[x][y] = true;
            int nextX = x + direction[index][0], nextY = y + direction[index][1];
            if (nextX < 0 || nextX >= m || nextY <0 || nextY >= n || visited[nextX][nextY])
            {
                index = (index + 1) % 4;
            }
            x += direction[index][0];
            y += direction[index][1];
        }
        return ans;
    }
}
