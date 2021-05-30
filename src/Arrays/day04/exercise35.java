package Arrays.day04;

/**
 * @author sunchuanjia
 * @Description 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1

 * @create 2021-03-09 21:01
 */
public class exercise35 {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int low = 0,high = length - 1;
        int mid;
        while(low<high){
            mid = (low + high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target)
            {
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(nums[low]<target){
            return low + 1;
        }else{
            return low;
        }
    }
}
