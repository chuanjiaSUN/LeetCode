package prepareAutumn;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-01 21:32
 */
public class Pre215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums){
            queue.offer(num);
        }
        int ans = 0;
        for (int i = 0; i < k; i++){
            ans = queue.poll();
        }
        return ans;
    }

    Random random = new Random();
    public int findKthLargest1(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int target) {
        int q = randomPartition(nums, left, right);
        if (q == target) {
            return nums[q];
        }else{
            return q < target ? quickSelect(nums, q + 1, right, target) : quickSelect(nums, left, q - 1, target);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int x = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++){
            if (nums[j] <= x){
                swap(nums, ++i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int right) {
        int temp = nums[i];
        nums[i] = nums[right];
        nums[right] = temp;
    }


    /**
     * practice
     * */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length < k){
            return -1;
        }
        return quicklySelect(nums, 0, nums.length - 1, k);
    }

    private int quicklySelect(int[] nums, int left, int right, int k) {
        int pivot = randomPartition1(nums, left, right, k);
        if (pivot == k){
            return nums[pivot];
        }else{
            return pivot < k ? quicklySelect(nums, left, pivot - 1, k) : quicklySelect(nums, pivot + 1, right, k);
        }
    }

    private int randomPartition1(int[] nums, int left, int right, int k) {
        int pivot = new Random().nextInt(right - left + 1) + left;
        swap1(nums, pivot, right);
        return partition1(nums, left, right);
    }

    private int partition1(int[] nums, int left, int right) {
        int pivot = nums[right];
        int j = left - 1;
        for (int i = left; i <= right; i++){
            if (nums[i] <= pivot){
                j += 1;
                swap1(nums, i, j);
            }
        }
        swap1(nums, j + 1, right);
        return j + 1;
    }

    private void swap1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
