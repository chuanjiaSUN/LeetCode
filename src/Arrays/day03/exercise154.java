package Arrays.day03;

/**
 * @author sunchuanjia
 * @Description 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 输入: [2,2,2,0,1]
 * 输出: 0
 *
 * @create 2021-03-08 14:53
 */
public class exercise154 {
    public int findMin(int[] nums) {
        int length = nums.length;
        int low = 0, high = length - 1;
        int mid;
        while(low < high){

            mid = (low + high)/2;

            if(nums[mid]>nums[high]){
                low =  mid + 1;
            }else if(nums[mid]<nums[high]){
                high = mid;
            }else{
                high--;
            }

        }


        return nums[low];
    }
}
