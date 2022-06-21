package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-21 23:00
 */
public class Pre79 {
    boolean[][] visited;
    boolean find = false;
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int rows;
    int cols;
    public boolean exist(char[][] board, String word) {
        if (null == word || word.length() == 0){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        rows = m;
        cols = n;
        visited = new boolean[m][n];
        int len = word.length();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (find){
                    return true;
                }
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    dfs(i, j, len,1, board, word);
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private void dfs(int i, int j, int len, int index, char[][] board, String word) {
        if (index == len){
            find = true;
            return;
        }
        for (int[] dir : directions){
            int newI = dir[0] + i;
            int newJ = dir[1] + j;
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols){
                if (!visited[newI][newJ]){
                    if (board[newI][newJ] == word.charAt(index)){
                        visited[newI][newJ] = true;
                        dfs(newI, newJ, len,index + 1, board, word);
                        visited[newI][newJ] = false;
                    }
                }
            }
        }
    }
}
