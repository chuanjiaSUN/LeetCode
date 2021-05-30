package Arrays.day03;

/**
 * @author sunchuanjia
 * @Description  153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 *
 * @create 2021-03-08 11:17
 */
public class exercise153 {
    //法1 双指针  时间复杂度o(n)
    public int findMin(int[] nums) {
        int length = nums.length;
        int low=0, high = length -1 ;
        while(low<high){
            if(nums[low]<nums[high]){
                high--;
            }else{
                low++;
            }
        }
        return nums[low];
    }

    //法2 二分查找 时间复杂度O(logN)
    public int findMin1(int[] nums){
        int length = nums.length;
        int low = 0, high = length - 1;
        int mid;

        if(length == 1){
            return nums[0];
        }

        if (nums[high]>nums[low]){
            return nums[0];
        }

        while(low<high){
            mid = (low + high)/2;
            //一进来就找到了旋转后的分界点
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }

            //若没找到，根据mid点与第一点大小重新划分区间
            if (nums[mid]>nums[0]){
                low = mid +1 ;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        exercise153 e = new exercise153();
        int[] nums = {3,4,5,1,2};
        int min = e.findMin(nums);
        int min1 = e.findMin1(nums);
        System.out.println(min+" "+min1);
    }
}
