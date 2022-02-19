package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-19 15:05
 */
public class Exe31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        if (i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums,i + 1);
    }

    public void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public void reverse(int[] nums, int idx){
        int start = idx, end = nums.length - 1;
        while (start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
