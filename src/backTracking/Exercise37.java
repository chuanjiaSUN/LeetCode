package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-22 11:05
 */
public class Exercise37 {

    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[9][9][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();//存储空白位置
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    spaces.add(new int[]{i, j});
                }else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[ i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size())
        {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit)
        {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit])
            {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

    //法2 位运算优化
    private int[] lines = new int[9];
    private int[] columns = new int[9];
    private int[][] blocks = new int[3][3];
    private boolean isValid = false;
    private List<int[]> theSpaces = new ArrayList<>();
    public void solveSudoku1(char[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    theSpaces.add(new int[]{i, j});
                }else
                {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }
        dfs1(board, 0);
    }

    private void dfs1(char[][] board, int pos) {
        if (pos == theSpaces.size())
        {
            isValid = true;
            return;
        }

        int[] space = theSpaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(lines[i] | columns[j] | blocks[i / 3][j / 3]) & 0X1ff;
        for ( ; mask != 0 &&  ! valid; mask &= (mask - 1))
        {

            int digitMask = mask & ( -mask );
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char)(digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    private void flip(int i, int j, int digit) {
        lines[i] ^= ( 1 << digit );
        columns[j] ^= (1 << digit);
        blocks[i / 3][j / 3] ^= ( 1 << digit );
    }

    //枚举优化
    public void solveSudoku2(char[][] board)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] != '.')
                {
                    int digit = board[i][j] - '0' - 1;
                    flip1(i, j, digit);
                }
            }
        }
        while (true)
        {
            boolean modified = false;
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    if (board[i][j] == '.')
                    {
                        int mask = ~(lines[i] | columns[j] | blocks[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0)
                        {
                            int digit = Integer.bitCount(mask - 1);
                            flip1(i, j, digit);
                            board[i][j] = (char)(digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if ( ! modified )
            {
                break;
            }
        }
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == '.')
                {
                    spaces.add(new int[]{i, j});
                }
            }
        }
        dfs2(board, 0);

    }

    private void dfs2(char[][] board, int pos) {
        if (pos == spaces.size())
        {
            isValid = true;
            return;
        }
        int[] space= spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(lines[i] | columns[j] | blocks[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !isValid; mask &= (mask - 1))
        {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip1(i, j, digit);
            board[i][j] = (char)(digit + '0' + 1);
            flip1(i, j, digit);
        }
    }

    private void flip1(int i, int j, int digit) {
        lines[i] ^= ( 1 << digit);
        columns[j] ^= ( 1 << digit);
        blocks[ i / 3][j / 3] ^= ( 1 << digit);
    }
}
