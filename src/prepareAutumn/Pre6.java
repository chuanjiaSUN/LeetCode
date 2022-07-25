package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-12 20:42
 */
public class Pre6 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = s.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)){
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else{
                    if (matches(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
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
                    if (matches1(s, p, i, j - 1)){
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                }else{
                    if (matches(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches1(String s, String p, int i, int j) {
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
    public String convert1(String s, int numRows) {
        int len = s.length();
        if (numRows == 1 || numRows >= len){
            return s;
        }
        int time = 2 * numRows - 2;
        int cols = (len + time - 1) / time * (numRows - 1);
        char[][] arr = new char[numRows][cols];
        for (int i = 0, x = 0, y = 0; i < len; i++){
            arr[x][y] = s.charAt(i);
            if (i % time < numRows - 1){
                x++;
            }else{
                x--;
                y++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < cols; j++){
                if (arr[i][j] != 0){
                    sb.append(arr[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
