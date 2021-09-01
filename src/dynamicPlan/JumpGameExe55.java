package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-01 13:39
 */
public class JumpGameExe55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < length; i++)
       {
           if (i <= maxPosition)
           {
               maxPosition = Math.max(maxPosition, i + nums[i]);
           }
           if (maxPosition >= length - 1)
           {
               return true;
           }
       }
        return false;
    }
}

