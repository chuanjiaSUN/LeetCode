package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-01 22:32
 */
public class Pre36 {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subBox = new int[3][3][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                char c = board[i][j];
                if (c != '.'){
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    cols[j][index]++;
                    subBox[i / 3][j / 3][index]++;
                    if(rows[i][index] > 1 || cols[j][index] > 1 || subBox[i / 3][j / 3][index] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
