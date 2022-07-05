package prepareAutumn;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-02 20:52
 */
public class Pre239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++){
            queue.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[len - k + 1];
        ans[0] =  queue.peek()[0];
        for (int i = k; i < len; i++){
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k){
                queue.poll();
            }
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        int[] ans = new int[len - k + 1];
        ans[0] = nums[queue.peekFirst()];
        for (int i = k; i < len; i++){
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while (queue.peekFirst() <= i - k){
                queue.pollFirst();
            }
            ans[i - k + 1] = nums[queue.peekFirst()];
        }
        return ans;
    }
}
