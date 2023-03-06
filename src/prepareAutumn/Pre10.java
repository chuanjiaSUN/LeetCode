package prepareAutumn;

import sun.management.jdp.JdpJmxPacket;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-25 22:25
 */
public class Pre10 {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];//不匹配
                    if (match(s, p, i, j - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else{
                    if (match(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0){
            return false;
        }
        if (p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * practice
     * */
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (matchLetter(s, p, i, j - 1)){
                        dp[i][j] |= dp[i - 1][j];
                    }
                }else{
                    if (matchLetter(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matchLetter(String s, String p, int i, int j) {
        if (i == 0){
            return false;
        }
        if (p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * practice
     * */
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (matchChar(s, p, i, j - 1)){
                        dp[i][j] |= dp[i - 1][j];
                    }
                }else {
                    if (matchChar(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matchChar(String s, String p, int i, int j) {
        if (i == 0){
            return false;
        }
        if (p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
