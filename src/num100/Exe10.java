package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 15:24
 */
public class Exe10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;

        for(int i = 0; i <= m ; i++){
            for (int j = 1; j <= n ; j++){
                if (p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)){
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }else{
                    if (matches(s, p, i, j)){
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0){
            return false;
        }
        if (p.charAt(j - 1) == '.'){
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * 2023-3-6
     * */
    public boolean isMatch1(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++){
            for (int j = 1; j <= len2; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch2(s, p, i, j - 1)){
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                }else{
                    if (isMatch2(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    private boolean isMatch2(String s, String p, int i, int j) {
        if (i == 0){
            return false;
        }
        if (p.charAt(j - 1) == '.'){
            return true;
        }
        return p.charAt(j - 1) == s.charAt(i - 1);
    }
}
