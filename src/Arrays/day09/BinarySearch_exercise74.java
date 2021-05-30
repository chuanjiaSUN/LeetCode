package Arrays.day09;

/**
 * @author sunchuanjia
 * @Description 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 *输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * @create 2021-03-15 21:59
 */
public class BinarySearch_exercise74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null ||matrix.length == 0)return false;

        int row = matrix.length,column = matrix[0].length;
        boolean isEqual = false,isBig = true;
        for(int i=0;i<row;i++)
        {
            if(i>1 && matrix[i][0]<=matrix[i-1][column-1])
            {
                isBig = false;
                break;
            }
            int low = 0,high = column-1,mid ;
            while(low<high)
            {
                mid = (low+high)/2;
                if(matrix[i][mid]<target)
                {
                   low = mid + 1;
                }else{
                    high = mid ;
                }
            }
            if(matrix[i][low] == target)
            {
                isEqual = true;
            }
        }
        if(isBig && isEqual)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearch_exercise74 e = new BinarySearch_exercise74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        boolean b = e.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
