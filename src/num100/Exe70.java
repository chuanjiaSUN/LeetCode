package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-21 15:04
 */
public class Exe70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + 2;
        }
        return dp[n];
    }
}
