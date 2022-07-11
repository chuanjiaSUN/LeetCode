package prepareAutumn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-07 22:32
 */
public class Pre347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
             if (queue.size() == k){
                 if (queue.peek()[1] <= val){
                     queue.poll();
                     queue.offer(new int[]{key, val});
                 }
             }else{
                 queue.offer(new int[]{key, val});
             }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
