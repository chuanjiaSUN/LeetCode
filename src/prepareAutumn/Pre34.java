package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-15 21:49
 */
public class Pre34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean low) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] > target || (low && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

}
