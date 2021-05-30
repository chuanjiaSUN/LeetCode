package Arrays.day05;

/**
 * @author sunchuanjia
 * @Description 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假nums[-1] = nums[n] = -∞ 。
 *

 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 *

 * @create 2021-03-10 9:52
 */
public class exercise162 {

    //法1 线性扫描 复杂度为O(n)
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int left = 0,high = length - 1;
        for(int i=0;i<length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                return i;
            }
        }
        return length-1;
    }

    //法2 递归二分查找
    public int findPeakElement1(int[] nums){
        int length = nums.length;

        return searchPeak(nums,0,length-1);
    }

    public int searchPeak(int[] nums,int left,int right)
    {
        if(left == right)
        {
            return left;
        }
        int mid = (left + right)/2;
        if(nums[mid]<nums[mid+1]){
            return searchPeak(nums,mid+1,right);
        }
        return searchPeak(nums,left,mid);

    }

    //法3 迭代2分法查找
    public int findPeakElement2(int[] nums){
        int length = nums.length;
        int left = 0,right = length - 1,mid;
        while(left<right)
        {
            mid = (left + right)/2;
            if(nums[mid]<nums[mid+1])
            {
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        exercise162 e = new exercise162();
        int peakElement1 = e.findPeakElement1(nums);
        int peakElement2 = e.findPeakElement2(nums);
        System.out.println(peakElement1);
        System.out.println(peakElement2);
    }
}
