package Arrays.day11;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
。
 * @create 2021-03-17 11:03
 */
public class stack_hash_DongGui_exercise85 {
    //法1 单调栈
    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        if(rows==0)return 0;
        int columns = matrix[0].length;
        int[][] left = new int[rows][columns];
        for(int i=0;i<rows;i++)
        {
            for (int j=0;j<columns;j++)
            {
                if(matrix[i][j]=='1')
                {
                    left[i][j] = (j==0? 0: left[i][j-1]) + 1;//计算每一点左边连续1的个数
                }
            }
        }


        //按每一列计算柱状图面积
        int answer = 0;
        for(int j=0;j<columns;j++)
        {
            Stack<Integer> stack = new Stack<>();
            int[] upBound = new int[rows];
            int[] downBound = new int[rows];
            Arrays.fill(downBound,rows);//一次遍历计算完上下边界

            for(int i=0;i<rows;i++)
            {
                while(!stack.isEmpty() && left[stack.peek()][j]>=left[i][j])
                {
                    downBound[stack.peek()] = i;
                    stack.pop();
                }
                upBound[i] = (stack.isEmpty()?-1:stack.peek());
                stack.push(i);
            }

            for(int i=0;i<rows;i++)
            {
                int height = downBound[i] - upBound[i] - 1;
                int area ;
                area = height*left[i][j];
                answer = Math.max(area,answer);
            }

        }
        return answer;
    }

    //法2 暴力解法
    public int maximalRectangle1(char[][] matrix){
        int row = matrix.length;
        if(row ==0) return 0;
        int column = matrix[0].length;
        int[][] left = new int[row][column];
        //计算每个位置左边连续1的长度
        for(int i = 0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(matrix[i][j]=='1')
                {
                    left[i][j] = (j==0?0:left[i][j-1]) + 1;
                }
            }
        }

        int answer=0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(matrix[i][j]=='0') continue;
                int width = left[i][j];
                int area = 0;
                for(int k = i-1;k>0;k--)
                {
                    if(matrix[k][j]=='0')break;
                    else {
                        width = Math.min(width,left[k][j]);
                        area = Math.max(area,width * (i-k+1));
                    }
                }
                answer = Math.max(area,answer);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        char[][] chars ={{'0','1'}};
        stack_hash_DongGui_exercise85 e = new stack_hash_DongGui_exercise85();
        int i = e.maximalRectangle(chars);
        System.out.println(i);
    }


}
