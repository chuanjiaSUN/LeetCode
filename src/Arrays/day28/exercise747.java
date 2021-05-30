package Arrays.day28;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-04 13:01
 */
public class exercise747 {
    public int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE,index = -1;
        for(int i = 0; i < nums.length; i++)
        {
            if(maxNum < nums[i])
            {
                maxNum =  nums[i];
                index = i;
            }
        }
        for( int i = 0; i < nums.length; i++)
        {
            if(i != index && 2 * nums[i] > maxNum)
            {
                return -1;
            }
        }
        return index;
    }
}
