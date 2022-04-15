package Arrays;



/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-21 18:23
 */
public class mergeSort {

    private static final int THRESHOLD = 7;
    public int[] sort(int[] nums){
        int len = nums.length;

        int[] temp = new int[len];
        merge(nums, 0, len - 1, temp);
        return nums;
    }

    private void merge(int[] nums, int left, int right, int[] temp) {
        if (right - left <= THRESHOLD){
            insetSort(nums, left, right);
            return;
        }

        int mid = (right + left) >> 1;

        merge(nums, left, mid, temp);
        merge(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]){
            return;
        }
        mergeTwo2One(nums, left, mid, right, temp);
    }

    private void mergeTwo2One(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right + 1 - left);

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if (j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else{
                nums[k] = temp[j];
                j++;
            }
        }
    }

    private void insetSort(int[] nums, int left, int right) {
        int len = nums.length;
        for (int i = 1; i < len; i++){
            int temp = nums[i];

            int j = i;
            while (j > 0 && nums[j - 1] > temp){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
