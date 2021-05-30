package Arrays.day04;

/**
 * @author sunchuanjia
 * @Description 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 *
 * @create 2021-03-09 11:08
 */
public class exercise31 {
    public void nextPermutation(int[] nums){
        int length = nums.length;
        int i=length-2;
        while(i>=0&&nums[i]>=nums[i+1])
        {
            i--;
        }

        if(i>=0){
            int higher = length-1;
            while(higher>0){
                if(nums[higher]<=nums[i]){
                    higher--;
                }else{
                    break;
                }
            }
            int temp = nums[i];
            nums[i] = nums[higher];
            nums[higher] = temp;
        }

        int left = i+1,right = length-1;
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
