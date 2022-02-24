package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-23 16:17
 */
public class Exe79 {
    boolean[][] used;
    boolean ans;
    int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    backTrack(board, word, i, j, 0);
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void backTrack(char[][] board, String word, int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (index == word.length() - 1) {
            ans = true;
            return;
        }
        used[i][j] = true;
        for (int[] dir : direct) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!used[newI][newJ] && index + 1 < word.length() && board[newI][newJ] == word.charAt(index + 1)) {
                    backTrack(board, word, newI, newJ, index + 1);
                }
            }
        }
        used[i][j] = false;
    }
}
