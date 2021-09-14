package dynamicPlan;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-14 11:05
 */
public class Exe363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++)
        {
            int[] sum = new int[n];
            for (int j = i; j < m; j++)
            {
                for (int c = 0; c < n; c++)
                {
                    sum[c] += matrix[j][c];
                }
                TreeSet<Integer> sumSet = new TreeSet<>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum)
                {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null)
                    {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }
    /**朴素二维矩阵前缀和求和*/
    public int maxSumSubmatrix1(int[][] matrix, int k)
    {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = getMatrixSum(matrix);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (int p = i; p <= m; p++)
                {
                    for (int q = j; q <= n; q++)
                    {
                        int cur = sum[p][q] - sum[i - 1][q] - sum[p][ j - 1] + sum[i - 1][j - 1];
                        if (cur <= k)
                        {
                            ans = Math.max(ans, cur);
                        }
                    }
                }
            }
        }
        return ans;
    }
    /**前缀和 + 二分*/
    public int maxSumSubmatrix2(int[][] matrix, int k)
    {
        int[][] sum = getMatrixSum(matrix);
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        //遍历矩阵上边界
        for (int top = 1; top <= m; top++)
        {
            //遍历矩阵下边界
            for (int bot = top; bot <= m; bot++)
            {
                //使用有序集合维护所有遍历过的右边界
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int r = 1; r <= n; r++)
                {
                    //前缀和计算 right
                    int right = sum[bot][r] - sum[top - 1][r];
                    //二分查找left
                    Integer left = ts.ceiling(right - k);
                    if (left != null)
                    {
                        int cur = right - left;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(right);
                }
            }
        }
        return ans;
    }
    /**最大化二分收益*/
    public int maxSumSubmatrix3(int[][] matrix, int k)
    {
        int[][] sum = getMatrixSum(matrix);
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        //固定的是否为右边界
        boolean isRight = n > m;
        for (int i = 1; i <= (isRight ? m : n); i++)
        {
            for (int j = i; j <= (isRight ? m : n); j++)
            {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++)
                {
                    int a = isRight ? sum[j][fixed] - sum[i - 1][fixed] : sum[fixed][j] - sum[fixed][i - 1];
                    Integer b = ts.ceiling(a - k);
                    if (b != null)
                    {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }

    /**空间优化, 前缀和计算下放到搜索子矩阵过程中*/
    public int maxSumSubmatrix4(int[][] matrix, int k)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean isRight = n > m ;
        int[] sum = isRight ? new int[n + 1] : new int[m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= (isRight ? m : n); i++)
        {
            Arrays.fill(sum, 0);
            for (int j = i; j <= (isRight ? m : n); j++)
            {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++)
                {
                    sum[fixed] += isRight ? matrix[j - 1][fixed - 1] : matrix[fixed - 1][j - 1];
                    a += sum[fixed];
                    Integer b = ts.ceiling( a - k);
                    if (b != null)
                    {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }
    /**预处理前缀和*/
    public int[][] getMatrixSum(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i- 1][j - 1];
            }
        }
        return sum;
    }
}
