package Arrays.day19;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。

 * @create 2021-03-25 11:12
 */
public class exercise414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<3)
        {
            return nums[nums.length-1];
        }
        int count = 1,idx=0;
        for(int i=nums.length-2;i>=0&& count < 3;i--)
        {

            if(nums[i]<nums[i+1])
            {
                count++;
            }
            idx = i;
        }
        if(count==3)
        {
            return nums[idx];
        }else{
            return nums[nums.length-1];
        }
    }
    //法2 遍历1次找三个最大值
    public int thirdMax1(int[] nums)
    {
     long max1 = Long.MIN_VALUE;
     long max2 = Long.MIN_VALUE;
     long max3 = Long.MIN_VALUE;

       int length = nums.length;
       for(int i=0;i<length;i++)
       {
           if(nums[i]>max1)
           {
               max3 = max2;
               max2 = max1;
               max1 = nums[i];
           }else if(nums[i] > max2 && nums[i] != max1)
           {
               max3 = max2;
               max2 = nums[i];
           }else if(nums[i]>max3 && nums[i] != max1 && nums[i] != max2){
               max3 = nums[i];
           }
       }
       return (int) (max3==Long.MIN_VALUE?max1:max3);
    }

    public static void main(String[] args) {
        exercise414 e = new exercise414();
        int[] nums = {3,2,1};
        int i = e.thirdMax(nums);
        System.out.println(i);
    }
}
