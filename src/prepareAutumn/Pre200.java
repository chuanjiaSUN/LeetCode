package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-28 22:02
 */
public class Pre200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    /**BFS*/
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1'){
                    ans++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new ArrayDeque<>();
                    queue.offer(i * cols + j);
                    while (!queue.isEmpty()){
                        int id = queue.poll();
                        int row = id / cols;
                        int col = id % cols;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1'){
                            queue.offer((row - 1) * cols + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row + 1][col] == '1'){
                            queue.offer((row + 1) * cols + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1'){
                            queue.offer(row * cols + (col - 1));
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col + 1] == '1'){
                            queue.offer(row * cols + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }
}
