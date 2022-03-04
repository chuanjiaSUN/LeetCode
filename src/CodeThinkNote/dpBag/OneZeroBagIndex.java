package CodeThinkNote.dpBag;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-03-02 15:41
 */
public class OneZeroBagIndex {
    public static void main(String[] args) {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};

        /**m表示背包容量*/
        int m = 4;

        int n = weights.length;
        /**一维滚动数组*/
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++){
            for (int j = m; j >= weights[i]; j--){
                f[j] = Math.max(f[j], f[j - weights[i]] + values[i]);
            }
        }
        System.out.println(f[m]);

        /**二维数组*/
        int[][] dp = new int[n + 1][m + 1];
        for (int i = m; i >= weights[0]; i--){
            dp[0][i] = dp[0][i - weights[0]] + values[0];
        }

        for (int i = 1; i < weights.length; i++){
            for (int j = 0; j <= m; j++){
                if (j < weights[i]) {
                    dp[i][j] = dp[i - 1][j];
                    System.out.print(dp[i][j] + " ");
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]]  + values[i]);
                    System.out.print(dp[i][j] + " ");
                }

            }
            System.out.println("\t");

        }
        System.out.println(dp[n - 1][m]);
    }
}
