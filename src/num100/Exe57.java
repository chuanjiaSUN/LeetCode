package num100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-20 17:04
 */
public class Exe57 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        int len = intervals.length;
        for(int i = 0; i < len; i++){
            int L = intervals[i][0], R = intervals[i][1];
            int j = i + 1;
            while (j < len && intervals[j][0] <= R){
                R = Math.max(intervals[j][1], R);
                j++;
            }
            ans.add(new int[]{L, R});
            i = j - 1;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
