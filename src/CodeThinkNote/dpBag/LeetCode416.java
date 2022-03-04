package CodeThinkNote.dpBag;

import java.lang.annotation.Target;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-02 16:43
 */
public class LeetCode416 {

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        int[] dp = new int[20001];
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if (sum %2 == 1) System.out.println(false);
        int target = sum / 2;

        for (int i = 0; i < nums.length; i++){
            for (int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        System.out.println(dp[target] == target);
    }
}
