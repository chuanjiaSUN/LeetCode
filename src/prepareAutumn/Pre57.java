package prepareAutumn;

import java.util.*;

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

    /**
     * practice
     * */
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int[] inte : intervals){
            queue.offer(inte);
        }
        queue.offer(newInterval);
        List<int[]> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            if (ans.size() > 0 && ans.get(ans.size() - 1)[1] > poll[0]){
                ans.get(ans.size() - 1)[1] = poll[1];
            }else{
                ans.add(poll);
            }
        }
        return ans.toArray(new int[0][]);
    }
}
