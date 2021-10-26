package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-26 11:46
 */
public class Exe861 {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ret = m * ( 1  << ( n - 1));

        for (int j = 1; j < n; j++)
        {
            int nOnes = 0;
            for (int[] ints : grid) {
                if (ints[0] == 1) {
                    nOnes += ints[j];
                } else {
                    nOnes += (1 - ints[j]);
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
}
