package Arrays.day08;

/**
 * @author sunchuanjia
 * @Description 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @create 2021-03-14 9:57
 */
public class exercise59 {
    public int[][] generateMatrix(int n) {
        int row = 0, column = 0;
        int target = n * n;
        int[][] matrix = new int[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[n][n];
        int direction = 0;
        for(int i=1;i<=target;i++)
        {
            matrix[row][column]  = i;
            visited[row][column] = true;
            System.out.println(matrix[row][column]);
            int nexRow = row + directions[direction][0], nextColumn = column + directions[direction][1];
            if(nexRow<0 || nexRow > n-1 ||nextColumn <0 || nextColumn > n-1 || visited[nexRow][nextColumn])
            {
                direction = (1 + direction ) % 4;
            }
            row += directions[direction][0];
            column += directions[direction][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n  = 3;
        exercise59 e = new exercise59();
        int[][] ints = e.generateMatrix(n);
    }
}
