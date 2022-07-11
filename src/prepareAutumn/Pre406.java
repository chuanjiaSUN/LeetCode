package prepareAutumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-10 21:37
 */
public class Pre406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] info : people){
            ans.add(info[1], info);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o2[1] - o1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people){
            int spaces = person[1] + 1;
            for (int i = 0; i < n; i++){
                if (ans[i] == null){
                    spaces--;
                    if (spaces == 0){
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
