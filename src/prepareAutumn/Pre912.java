package prepareAutumn;

import java.util.Random;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-05 11:26
 */
public class Pre912 {
    public int[] sortArray(int[] nums){
        int len = nums.length;
//        quicklySort(nums, 0, nums.length - 1);
        insertSort(nums, 0, len - 1);
        return nums;
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++){
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] >= temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private void quicklySort(int[] nums, int left, int right) {
        if (left < right){
            int pivot = randomPartition(nums, left, right);
            quicklySort(nums, left, pivot - 1);
            quicklySort(nums, pivot + 1, right);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++){
            if (nums[j] <= pivot){
                i += 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    /**
     * 插排
     * */

}
