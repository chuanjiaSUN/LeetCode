package Arrays.day27;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-03 14:15
 */
public class exercise724 {
    //前缀和
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for( int i = 0 ; i < nums.length; i++)
        {
            if( 2 * sum == total - nums[i])
            {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
         exercise724 e = new exercise724();
         int[] nums = {2,1,-1};
        int i = e.pivotIndex(nums);
        System.out.println(i);
    }

}
