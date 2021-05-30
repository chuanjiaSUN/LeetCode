package Arrays.day06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 * @create 2021-03-11 19:48
 */
public class exercise54 {

    //法1 模拟，一开始向右移动，当突破边界时，或者下一个位置已经访问过，则顺时针变向，并且继续移动
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int totalCount = m*n;
        boolean[][] visited = new boolean[m][n];
        int row = 0, col = 0;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};//定方向
        int position = 0;
        for(int i=0;i<totalCount;i++)
        {
            list.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[position][0],nexCol = col + directions[position][1];
            if(nextRow <0 || nextRow > m-1 || nexCol < 0 || nexCol > n - 1 || visited[nextRow][nexCol]){
                position = (1 + position) % 4;
            }
            row += directions[position][0];
            col += directions[position][1];
        }
        return  list;
    }

    //法2 将矩阵看做若干次，先输出最外层元素，再输出次外层元素，直到输出最内层为止
    public List<Integer> spiralOrder1(int[][] matrix){

        ArrayList<Integer> list = new ArrayList<>();

        if(matrix.length == 0){
            return list;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0,left = 0,bottom = rows - 1,right = cols - 1;
        while(left <= right && top<= bottom)
        {
            for(int column = left;column <= right;column++)
            {
                list.add(matrix[top][column]);
            }
            for(int row = top + 1;row<=bottom;row++)
            {
                list.add(matrix[row][right]);
            }
            //有可能遍历完外层后，矩阵只有一行或一列没有遍历了，此时不需要遍历 下方与左方元素
            if(left<right && top < bottom)
            {
                for(int column = right - 1;column>left;column--)
                {
                    list.add(matrix[bottom][column]);
                }
                for(int row = bottom ; row>top; row--)
                {
                    list.add(matrix[row][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return list;
    }

    public static void main(String[] args) {
        exercise54 e = new exercise54();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = e.spiralOrder1(matrix);
        System.out.println(list);
    }
}
