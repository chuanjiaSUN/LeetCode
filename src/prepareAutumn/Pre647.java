package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-14 22:48
 */
public class Pre647 {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for (int i = len - 1; i >= 0; i--){
            for (int j = i; j < len; j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (j - i <= 1){
                        dp[i][j] = true;
                        maxLen++;
                    }else if (dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        maxLen++;
                    }
                }
            }
        }
        return maxLen;
    }
}
