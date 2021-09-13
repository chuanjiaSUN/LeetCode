package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 11:47
 */
public class Exe396 {
    public int maxRotateFunction(int[] nums) {
       int sum = 0;
       int dp1 = 0, dp2 = 0;
       int len = nums.length;
       for (int i = 0; i < len; i++)
       {
           sum += nums[i];
           dp1 += i * nums[i];
       }
       int ans = dp1;
       for (int i = 1; i < len; i++)
       {
           dp2 = dp1 + sum - len * nums[len - i];
           ans = Math.max(ans, dp2);
           dp1 = dp2;
       }
       return ans;
    }
}
