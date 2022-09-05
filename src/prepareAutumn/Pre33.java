package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-15 21:18
 */
public class Pre33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * practice
     */
    public int search1(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * practice2
     */
    public int search2(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if (nums[mid] < target && target <= nums[len - 1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

}
