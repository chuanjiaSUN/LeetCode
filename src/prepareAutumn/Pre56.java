package prepareAutumn;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-17 21:59
 */
public class Pre56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals,(o1, o2) -> (o1[0] - o2[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left){
                merged.add(new int[]{left, right});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        return merged.toArray(new int[0][]);
    }

    public int[][] merge1(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] arr : intervals){
            queue.offer(arr);
        }
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
