package prepareAutumn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-09 22:58
 */
public class Pre52 {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> dia1 = new HashSet<>();
        Set<Integer> dia2 = new HashSet<>();
        return backTrack(columns, dia1, dia2, n, 0);
    }

    private int backTrack(Set<Integer> columns, Set<Integer> dia1, Set<Integer> dia2, int n, int row) {
        if (row == n){
            return 1;
        }else{
            int count = 0;
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
                columns.add(i);
                dia1.add(diagonal1);
                dia2.add(diagonal2);
                count += backTrack(columns, dia1, dia2, n, row + 1);
                columns.remove(i);
                dia1.remove(diagonal1);
                dia2.remove(diagonal2);
            }
            return count;
        }
    }
}
