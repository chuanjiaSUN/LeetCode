package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-01 22:48
 */
public class Pre37 {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] box = new boolean[3][3][9];
    boolean valid = false;
    List<int[]> spaces = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    spaces.add(new int[]{i, j});
                }else{
                    int index = board[i][j] - '0' - 1;
                    rows[i][index] = cols[j][index] = box[i / 3][j / 3][index] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()){
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9 && !valid; digit++){
            if (!rows[i][digit] && !cols[j][digit] && !box[i / 3][j / 3][digit]){
                rows[i][digit] = cols[j][digit] = box[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                rows[i][digit] = cols[j][digit] = box[i / 3][j / 3][digit] = false;
            }
        }
    }
}
