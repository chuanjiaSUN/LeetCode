package Arrays.day09;

/**
 * @author sunchuanjia
 * @Description 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12

 * @create 2021-03-15 21:06
 */
public class DongGui_exercise64 {

    //法1 动态规划
    public int minPathSum(int[][] grid) {

        if(grid.length==0||grid==null||grid[0].length==0)
        {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        for(int i=1;i<n;i++)
        {
            f[0][i] =f[0][i-1] + grid[0][i];
        }
        for(int i=1;i<m;i++)
        {
            f[i][0] = f[i-1][0] + grid[i][0];
        }


        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
               int min1 = f[i-1][j] + grid[i][j];
               int min2 = f[i][j-1] + grid[i][j];
               f[i][j] = Math.min(min1,min2);
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        DongGui_exercise64 dongGui_exercise64 = new DongGui_exercise64();
        int[][] grid = {{1,2,3},{4,5,6}};
        int i = dongGui_exercise64.minPathSum(grid);
        System.out.println(i);
    }
}
