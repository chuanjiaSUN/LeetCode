package prepareAutumn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-11 22:02
 */
public class Pre57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] arr : intervals){
            queue.offer(arr);
        }
        queue.offer(newInterval);
        List<int[]> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            if (ans.size() == 0 || (ans.get(ans.size() - 1)[1] < queue.peek()[0])){
                ans.add(queue.poll());
            }else{
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], queue.poll()[1]);
            }
        }
        return ans.toArray(new int[0][]);
    }
}
