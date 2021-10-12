package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-11 11:09
 */
public class Exe334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
        {
            return false;
        }
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums)
        {
            if (num > mid)
            {
                return true;
            }
            if (num <= min)
            {
                min = num;
            }else{
                mid = num;
            }
        }
        return false;
    }
}
