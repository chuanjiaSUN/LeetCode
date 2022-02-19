package num100;

import java.util.TreeMap;
import java.util.logging.Level;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-19 17:02
 */
public class Exe34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums,target, true);
        int rightIdx = binarySearch(nums, target, false);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target){
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int l = 0, right = nums.length - 1;
        int ans = nums.length;
        while (l <= right){
            int mid = l + ((right - l) >> 1);
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
