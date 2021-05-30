package Arrays.day08;

/**
 * @author sunchuanjia
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1

 * @create 2021-03-14 10:44
 */
public class DongGui_exertcise63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] f = new int[length][width];
        for(int i=0;i<width;i++) {
            if (obstacleGrid[0][i] == 1) {
                f[0][i] = 0;
                break;
            }else{
                f[0][i] = 1;
            }
        }
        for(int i=0;i<length;i++)
        {
            if (obstacleGrid[i][0] == 1) {
                f[i][0] = 0;
                break;
            }else{
                f[i][0] = 1;
            }
        }
        for(int i = 1;i<length;i++)
        {
            for(int j = 1; j<width;j++)
            {
                if(obstacleGrid[i][j]==1)
                {
                    f[i][j] = 0;
                    continue;
                }
                if(obstacleGrid[i][j-1]==0){
                    f[i][j] += f[i][j-1];
                }
                if(obstacleGrid[i-1][j]==0)
                {
                    f[i][j] += f[i-1][j];
                }
            }
        }
        return f[length-1][width-1];
    }

    //法2 带入滚动数组思想，将存储每个位置路径的复杂度由O(mn)降为O(m)
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];//采用滚动数组思想存储每一排位置的路径数
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) { //内循环遍历时计算每一排的路径数，
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {//f[j] = f[j] + f[j-1],右边的f[j]为上面位置的路径数，f[j-1]为左边位置的路径数
                    f[j] += f[j - 1];//当j-1等于0时，到该位置的路径只有从上往下走，因此f[j]不变，依然是上次的值。
                }
            }
        }
        return f[m-1];
    }
}
