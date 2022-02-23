package num100;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-20 17:18
 */
public class Exe62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    //优化
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i ==0 && j == 0){
                    dp[j] = 1;
                }else if (j == 0){
                    dp[j] = dp[j];
                }else if (i == 0){
                    dp[j] = dp[j - 1];
                }else{
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}
