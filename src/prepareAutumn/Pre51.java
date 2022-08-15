package prepareAutumn;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-08 23:33
 */
public class Pre51 {
    /**
     * TODO 需要练习
     * */
    List<List<String>> ans = new ArrayList<>();
    boolean[][] used;
    public List<List<String>> solveNQueens(int n) {
        used = new boolean[n][n];
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> dia1 = new HashSet<>();
        Set<Integer> dia2 = new HashSet<>();
        backTrack(queens, n, 0, columns, dia1, dia2);
        return ans;
    }

    private void backTrack(int[] queens, int n, int row, Set<Integer> columns, Set<Integer> dia1, Set<Integer> dia2) {
        if (row == n){
            List<String> board = generateBoard(queens, n);
            ans.add(board);
        }else{
            for (int i = 0; i < n; i++){
                if (columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if (dia1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if (dia2.contains(diagonal2)){
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                dia1.add(diagonal1);
                dia2.add(diagonal2);
                backTrack(queens, n, row + 1, columns, dia1, dia2);
                queens[row] = -1;
                columns.remove(i);
                dia1.remove(diagonal1);
                dia2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++){
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
