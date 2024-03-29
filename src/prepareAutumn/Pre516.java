package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-07 19:52
 */
public class Pre516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--){
            for (int j = i + 1; j < len; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }
}
