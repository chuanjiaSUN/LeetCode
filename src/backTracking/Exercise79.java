package backTracking;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-24 10:50
 */
public class Exercise79 {
    boolean[][] visited;
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
      int h = board.length, w = board[0].length;
      visited = new boolean[h][w];
      for (int i = 0; i < h; i++)
      {
          for (int j = 0; j < w; j++)
          {
              boolean flag = check(board, visited, i, j, word, 0);
              if (flag)
              {
                  return true;
              }
          }
      }
      return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k))
        {
            return false;
        }else if (k == word.length() - 1)
        {
            return true;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] dir : direction)
        {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI >=0 && newI < board.length && newJ >=0 && newJ < board[0].length)
            {
                if (!visited[newI][newJ])
                {
                    boolean flag = check(board, visited, newI, newJ, word, k + 1);
                    if (flag)
                    {
                        res = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return res;
    }

    /**
     * 法2 自己写的
     * */
    boolean ans = false;
    static final int DIR_COUNT = 4;
    public boolean exist1(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        visited = new boolean[row + 1][column + 1];
        int len = word.length();
        if (len == 0)
        {
            return false;
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                backTrack(board, word, row, column, i, j, 0);
            }
        }
        return ans;
    }

    private void backTrack(char[][] board, String word, int row, int column, int rowStart, int columnStart, int k) {
        if (k == word.length())
        {
            ans = true;
            return;
        }
        if (rowStart >= row || columnStart >= column || rowStart <0 || columnStart < 0)
        {
            return;
        }
        if (board[rowStart][columnStart] != word.charAt(k))
        {
            return;
        }
        for (int i = 0; i < DIR_COUNT; i++)
        {
            if (!visited[rowStart][columnStart])
            {
                visited[rowStart][columnStart] = true;
                backTrack(board, word, row, column, rowStart + direction[i][0], columnStart + direction[i][1], k + 1);
                visited[rowStart][columnStart] = false;
            }
        }
    }

    /**
     * 法3 剪枝优化
     * */
    int rows;
    int cols;
    int len;
    char[] charArray;
    char[][] board;
    public boolean exist2(char[][] board, String word)
    {
        rows = board.length;
        if (rows == 0)
        {
            return false;
        }
        cols = board[0].length;
        visited = new boolean[rows][cols];

        this.len = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                if (track(i, j, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean track(int x, int y, int strBegin) {
        if (strBegin == len - 1)
        {
            return board[x][y] == charArray[strBegin];
        }
        if (board[x][y] == charArray[strBegin])
        {
            visited[x][y] = true;
            for (int[] dir : direction)
            {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (inArea(newX, newY) && !visited[newX][newY])
                {
                    if (track(newX, newY, strBegin + 1))
                    {
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }

    private boolean inArea(int newX, int newY) {
        return newX >= 0 && newX < rows && newY >=0 && newY < cols;
    }

}
