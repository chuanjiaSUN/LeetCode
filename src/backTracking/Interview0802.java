package backTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-12 21:00
 */
public class Interview0802 {

    List<List<Integer>> ans;
    List<List<Integer>> path;
    int[][] directions = new int[][]{{1, 0}, {0, 1}};
    int rows;
    int cols;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
        {
            return ans;
        }
        backTrack(obstacleGrid, 0, 0);
        return ans;
    }

    private void backTrack(int[][] obstacleGrid, int row, int col) {
        if (row == rows - 1 && col == cols - 1)
        {
            ans = new ArrayList<>(path);
            List<Integer> last = new ArrayList<>();
            last.add(rows);
            last.add(cols);
            ans.add(new ArrayList<>(last));
            return;
        }
        if (row > rows || col > cols)
        {
            return;
        }
        for (int[] dir : directions)
        {
            List<Integer> temp = new ArrayList<>();
            if (row < rows && col < cols)
            {
                if (obstacleGrid[row][col] == 0)
                {
                    temp.add(row);
                    temp.add(col);
                    path.add(new ArrayList<>(temp));
                    System.out.println(path);
                    backTrack(obstacleGrid, row + dir[0], col + dir[1]);
                    path.remove(path.size() - 1);
                }
            }

        }
    }

    /**法 2*/
    public List<List<Integer>> pathWithObstacles1(int[][] obstacleGrid)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (obstacleGrid.length > 0 && obstacleGrid[0].length > 0)
        {
            find(obstacleGrid, 0, 0, obstacleGrid.length - 1, obstacleGrid[0].length - 1, ans);
        }
        return ans;
    }

    private boolean find(int[][] obstacleGrid, int x, int y, int height, int width, List<List<Integer>> ans) {
        if (obstacleGrid[x][y] == 1)
        {
            return false;
        }
        if (x == height && y == width)
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(x);
            temp.add(y);
            ans.add(temp);
            return true;
        }else if ((x < height && find(obstacleGrid, x + 1, y, height, width, ans))
                ||
                (y < width && find(obstacleGrid, x, y + 1, height, width, ans)))
        {
            List<Integer> temp = new ArrayList<>();
            temp.add(x);
            temp.add(y);
            ans.add(0, temp);
            return true;
        }
        obstacleGrid[x][y] = 1;
        return false;
    }

    public static void main(String[] args) {
        Interview0802 e = new Interview0802();
        int[][] obstacle = new int[][]
                {
                        {0,0,0},
                        {0,1,0},
                        {0,0,0},
                };
        List<List<Integer>> lists = e.pathWithObstacles(obstacle);
        System.out.println(lists);
    }
}
