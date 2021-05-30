package Arrays.day04;

/**
 * @author sunchuanjia
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 *
 * @create 2021-03-09 16:00
 */
public class exercise34 {
    public int[] searchRange(int[] nums, int target){
        int i = binarySearchFirstPlace(nums,target);
        int y = binarySearchLastPlace(nums,target);
        return new int[]{i,y};
    }

    public int binarySearchFirstPlace(int[] nums,int target){
        int length = nums.length;
        int left = 0,right = length-1;
        int mid;
        while(left<right)
        {
            mid = (left + right)/2;
            if(nums[mid]<target){
                left = mid + 1;
            }else if(nums[mid]==target)
            {
                right = mid;
            }else{
                right = mid - 1;
            }
        }

        if(nums[left]==target)
        {
            return  left;
        }
        return -1;
    }

    public int binarySearchLastPlace(int[] nums,int target){
        int length = nums.length;
        int left = 0,right = length-1;
        int mid;
        while(left<right)
        {
            mid = (left + right+1)/2;//向上取整，不然 取到相等时第二个条件使left永远小于right无法退出循环
            if(nums[mid]<target){
                left = mid + 1;
            }else if(nums[mid]==target)
            {
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        if(nums[left]==target)
        {
            return  left;
        }
        return -1;
    }

    //法2
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;//因为这时mid为找到的值，而退出循环时left>right,不能直接返回left,只能返回ans
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        exercise34 e = new exercise34();
        int[] ints = e.searchRange1(nums, 8);
        for(int i:ints){
            System.out.println(i);
        }
    }
}
