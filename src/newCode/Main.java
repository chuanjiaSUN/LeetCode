package newCode;

public class Main{
    public static void main(String[] args) {
        Main main = new Main();
        int[][] matrix = new int[][]{
                {1,3,7,6,7,9},
                {2,3,4,5,6,6},
                {1,2,4,5,6,7},
                {4,1,22,33,4,7},
                {3,6,7,10,9,11}};
        int[] ints = main.get(matrix);
        System.out.println(ints);
    }

    public int[] get(int[][] matrix){
        if (matrix == null){
            return new int[]{-1, -1};
        }
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++){
            int l = 0, r = n - 1;
            while (l < r){
                int mid = (l + r) >> 1;
                if (matrix[i][mid] < matrix[i][mid + 1]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            System.out.println(l);
            if (i - 1 >= 0 && i + 1 < m){
                if (matrix[i][l] > matrix[i - 1][l] && matrix[i][l] > matrix[i + 1][l]){
                    return new int[]{i, l};
                }
            }
        }
        return null;
    }
}