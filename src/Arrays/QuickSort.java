package Arrays;

import java.util.Random;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-02 11:08
 */
public class QuickSort {
    /**practice*/
    public int[] sortArray(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right){
            int pos = randomPartition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int i = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, i);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; ++j){
            if (nums[j] <= pivot){
                i = i + 1;
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

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        QuickSort quickSort = new QuickSort();
        quickSort.quicklySort(nums);
        for (int num : nums){
            System.out.println(num);
        }
    }



    public void quicklySort(int[] nums){
        if (null == nums || nums.length == 0){
            return;
        }
        quick(nums, 0, nums.length - 1);
        return;
    }

    private void quick(int[] nums, int left, int right) {
        if (left < right){
            int pivot = randomPartitionSort(nums, left, right);
            quick(nums, left, pivot - 1);
            quick(nums, pivot + 1, right);
        }
    }

    private int randomPartitionSort(int[] nums, int left, int right) {
        int pivot = new Random().nextInt(right - left + 1) + left;
        swap(nums, right, pivot);
        return partitionSort(nums, left, right);
    }

    private int partitionSort(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++){
            if (nums[j] <= pivot){
                swap(nums, i + 1, j);
                i += 1;
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }
}
