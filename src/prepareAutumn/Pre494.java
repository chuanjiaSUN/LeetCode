package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-11 22:36
 */
public class Pre494 {
    int ans = 0;
    int[] symbol = new int[]{1, -1};
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int target, int idx, int path) {
        if (idx == nums.length){
            if (path == target){
                ans++;
            }
            return;
        }
        if (idx > nums.length){
            return;
        }
        for (int sym : symbol){
            int temp = nums[idx] * sym;
            dfs(nums, target, idx + 1, path + temp);
        }
    }

    /**
     * dp
     * */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int n = nums.length;
        int[][] dp = new int[n][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n - 1][neg];
    }
}
