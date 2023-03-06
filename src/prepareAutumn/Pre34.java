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

    /**
     * practice
     * */
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = find(nums, target, true);
        int rightIdx = find(nums, target, false) - 1;
        if (leftIdx <= rightIdx && nums[leftIdx] == target && nums[rightIdx] == target && rightIdx < nums.length){
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int find(int[] nums, int target, boolean low) {
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

    /**
     * practice
     * @create 22-08-3023点06分
     * */
    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        int leftIndex = findSmall(nums, target);
        int rightIndex = findLarge(nums, target);
        if (leftIndex < rightIndex && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex, rightIndex};
        }
        return new int[]{-1, -1};
    }

    private int findLarge(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }

    private int findSmall(int[] nums, int target) {
        int left = 0;
        int rigiht = nums.length - 1;
        while (left < rigiht){
            int mid = left + (rigiht - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                rigiht = mid;
            }
        }
        return left;
    }
    /**
     * practice
     * */
    public int[] searchRange3(int[] nums, int target) {
        int len = nums.length;
        int left = find1(nums, target);
        int right = find2(nums, target);
        if (left <= right && nums[left] == target && nums[right] == target){
            return new int[]{left, right};
        }else{
            return new int[]{-1, -1};
        }
    }

    private int find1(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return left;
    }

    private int find2(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right){
            int mid = (left + right) >>> 1;
            if (nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
