package newCode;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-05 12:29
 */
public class MeiTuan {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 1, 2, 0, 3, 5, 4, 6};
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (Math.abs(nums[j] - nums[i]) > 1){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
                res = Math.max(res, dp[j]);
            }
        }

        System.out.println(res);
    }
}
