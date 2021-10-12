package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-12 11:30
 */
public class Exe406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) ->{
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people)
        {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
