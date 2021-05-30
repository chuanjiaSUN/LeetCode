package Arrays.day10;

/**
 * @author sunchuanjia
 * @Description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true

 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 *
 * @create 2021-03-16 13:27
 */
public class BinarySearch_exercise81 {
    //要想办法取出重复元素
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int low = 0,high = length - 1,mid;
        while(low<high)
        {
            mid = (low + high )/2;
            if(nums[mid]==target)
            {
                return true;
            }
            if(nums[mid]==nums[low])
            {
                low++;
                continue;
            }
            if(nums[mid]>nums[low]){//mid在前半部分
                if(nums[mid]>target && target>=nums[low])//往左边找
                {
                    high = mid - 1;
                }else if(target >nums[mid]||target<nums[low]){//往右边找，跨分界点
                    low = mid + 1;
                }
            }else if(nums[mid]<nums[low]){//mid在后半部分
                if(nums[mid]>target || target>nums[high])//往左边找，跨分界点
                {
                    high = mid - 1;
                }else if(target<=nums[high] && nums[mid]<target){//往右边找
                    low = mid + 1;
                }
            }
        }
        if(nums[low]==target){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        BinarySearch_exercise81 e = new BinarySearch_exercise81();
        boolean search = e.search(nums, 13);
        System.out.println(search);
    }
}
