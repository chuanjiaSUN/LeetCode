package Arrays.day28;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-04 13:08
 */
public class exercise766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int j = 0;
        for(int i = 0; i < rows; i++)
        {
            while(j < columns)
            {
                int k = i, l = j;
                while( k < rows-1 && l < columns-1 && matrix[k][l] == matrix[k+1][l+1])
                {
                    k++;
                    l++;
                }
                if( k < rows-1 && l < columns-1 && matrix[k][l] != matrix[k+1][l+1])
                {
                    return false;
                }
                j++;
            }
            j = 0;
        }
        return true;
    }
}
