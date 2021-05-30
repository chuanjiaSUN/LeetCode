package Arrays.day24;

/**
 * @author sunchuanjia
 * @Description 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

 * 输入：nums = [1,2,3]
 * 输出：6
 *
 * 输入：nums = [1,2,3,4]
 * 输出：24

 * @create 2021-03-30 9:19
 */
public class exercise628 {
    public int maximumProduct(int[] nums) {
        int length = nums.length;
        if (length < 3) return 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        //计算最大的三个数和最小的两个数
        for(int num:nums)
        {
            if(num < min1)
            {
                min2 = min1;
                min1 = num;
            }else if(num < min2)
            {
                min2 = num;
            }

            if(num > max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num > max2)
            {
                max3 = max2;
                max2 = num;
            }else if( num > max3)
            {
                max3 = num;
            }
        }

        return Math.max(max1*max2*max3,min1*min2*max1);
    }

    public static void main(String[] args) {
        exercise628 e = new exercise628();
        int[] nums = {-100,-2,-3,1};
        int i = e.maximumProduct(nums);
        System.out.println(i);
    }
}
