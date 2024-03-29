package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-22 22:16
 */
public class Pre96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
    /**
     * practice
     * */
    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
