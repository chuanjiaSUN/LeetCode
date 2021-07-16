package backTracking;


import java.io.FileReader;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-15 20:14
 */
public class SwordOffer12 {
    boolean[][] visited;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    StringBuilder sb;
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        sb = new StringBuilder();
        for(int i = 0 ; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    if (backTrack(board, word, i, j))
                    {
                        return true;
                    };
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, int x, int y) {
        if (word.equals(sb.toString()))
        {
            return true;
        }
        sb.append(board[x][y]);
        visited[x][y] = true;
        for (int[] dir : directions)
        {

            if (word.equals(sb.toString()))
            {
                return true;
            }
            int newX = x + dir[0], newY = y + dir[1];
            if (newX < 0 || newX >= board.length)
            {
                continue;
            }
            if (newY < 0 || newY >= board[0].length)
            {
                continue;
            }
            if (!visited[newX][newY])
            {
                if (backTrack(board, word, newX, newY))
                {
                    return true;
                }
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        visited[x][y] = false;
        return false;
    }

    /**法2 节约空间*/
    public boolean exist1(char[][] board, String word)
    {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (dfs(board, words,  i, j, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int x, int y, int pos) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != words[pos])
        {
            return false;
        }
        if (pos == words.length - 1){
            return true;
        }
        board[x][y] = '\0';
        boolean res = dfs(board, words, x + 1, y, pos + 1) ||
                dfs(board, words, x - 1, y, pos + 1) ||
                dfs(board, words, x, y + 1, pos + 1) ||
                dfs(board, words, x, y - 1, pos + 1);
        board[x][y] = words[pos];
        return res;
    }
}
