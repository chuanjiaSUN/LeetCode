package Arrays.day09;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法
 *  示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]

 * @create 2021-03-15 21:26
 */
public class exercise73 {

    //法1 用2个hashset分别存储值为0的行、列下表  空间复杂度为O(M+N)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(rows.contains(i)&&columns.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static final int MODIFIED = -100000;
    //法2  空间复杂度为O（1）将元素为0的行、列其他值设为很小的数,时间复杂度为O(m*n)*(m+n)，时间消耗太大了
    public void setZeroes1(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    for(int k=0;k<n;k++)
                    {
                        if(matrix[i][k]!=0)
                        {
                            matrix[i][k] = MODIFIED;
                        }
                    }
                    for(int l=0;l<m;l++)
                    {
                        if(matrix[l][j]!=0)
                        {
                            matrix[l][j] = MODIFIED;
                        }
                    }
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==MODIFIED)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //法3  遍历矩阵，当matrix[i][j]==0时，将第i行第一个第j列第一个元素设为0
    public void setZeroes2(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        Boolean isCol = false;//标记第0列是否有0元素

        for(int i=0;i<m;i++)
        {
            if(matrix[i][0]==0)
            {
                isCol = true;
            }
            for(int j=1;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0]==0)
        {
            for(int j=0;j<n;j++)
            {
                matrix[0][j] = 0;
            }
        }
        if(isCol)
        {
            for(int i=0;i<m;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}
