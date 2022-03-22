package Interview;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-22 14:13
 */
public class Walk {

    static final int MOD = 1000000007;
    public int walkHigh(int n, int m){
        int[][][] dp = new int[n + 1][m + 1][m + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                for (int k = 0; k <= m; k++){
                    for (int l = 0; l <= m; l++){
                        if (i <= j || (j == k && k != 0) || (j == l && l != 0) || (k == l && k != 0)){
                            continue;
                        }
                        dp[i][j][k] += dp[i - j][k][l];
                        dp[i][j][k] %= MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= m; j++){
                ans += dp[n][i][j];
                ans %= MOD;
            }
        }
        return ans;
    }
}
