package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-10 22:16
 */
public class Pre416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        return dfs(nums, target, 0);
    }

    private boolean dfs(int[] nums, int target, int idx) {
        if (target == 0){
            return true;
        }
        if (target < 0){
            return false;
        }
        if (idx >= nums.length){
            return false;
        }
            boolean left = dfs(nums, target - nums[idx], idx+1);
            boolean right = dfs(nums, target, idx + 1);

        return left || right;

    }

    /**dp*/
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if (nums.length < 2){
            return false;
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= target; j++){
                if (j >= nums[i]){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n - 1][target];
    }
}
