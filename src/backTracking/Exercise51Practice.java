package backTracking;


import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-23 11:11
 */
public class Exercise51Practice {
    List<List<String>> ans;
    public List<List<String>> solveNumQueens(int n)
    {
        ans = new ArrayList<>();
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backTrack(queens, n, 0, columns, diagonals1, diagonals2);
        return ans;
    }

    private void backTrack(int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n)
        {
            List<String> board = generate(queens, n);
            ans.add(board);
        }else
        {
            for (int i = 0; i < n; i++)
            {
                if (columns.contains(i))
                {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1))
                {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2))
                {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backTrack(queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private List<String> generate(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            char[] queen = new char[n];
            Arrays.fill(queen, '.');
            queen[queens[i]] = 'Q';
            board.add(String.valueOf(queen));
        }
        return board;
    }

}
