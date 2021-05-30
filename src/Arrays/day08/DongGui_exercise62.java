package Arrays.day08;

/**
 * @author sunchuanjia
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下

 * @create 2021-03-14 10:26
 */
public class DongGui_exercise62 {
    //动态规划，由于只能向右、向下移动，因此到达f[i][j]位置的路径只与f[i][j-1]、f[i-1][j]有关，且左上角到第一行点路径只有1条，到第一列点路径也只有一条
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        for(int i=0;i<n;i++)
        {
            f[0][i] = 1;
        }

        for(int i=0;i<m;i++)
        {
            f[i][0] = 1;
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m-1][n-1];
    }
}
