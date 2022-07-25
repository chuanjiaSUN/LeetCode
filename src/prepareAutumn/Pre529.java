package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-24 21:57
 */
public class Pre529 {
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
        }else{
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++){
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length){
                continue;
            }
            if (board[newX][newY] == 'M'){
                cnt++;
            }
        }
        if (cnt > 0){
            board[x][y] = (char)(cnt + '0');
        }else{
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++){
                int newX = x + dirX[i];
                int newY = y + dirY[i];
                if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || board[newX][newY] != 'E'){
                    continue;
                }
                dfs(board, newX, newY);
            }
        }
    }
}
