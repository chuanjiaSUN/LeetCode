package prepareAutumn;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-05 22:29
 */
public class Pre312 {
    int[][] res;
    int[] val;
    public int maxCoins(int[] nums) {
        int len = nums.length;
        val = new int[len + 2];
        for (int i = 1; i <= len; i++){
            val[i] = nums[i - 1];
        }
        val[0] = val[len + 1] = 1;
        res = new int[len + 2][len + 2];
        for (int i = 0; i <= len + 1; i++){
            Arrays.fill(res[i], -1);
        }
        return solve(0, len + 1);
    }

    private int solve(int left, int right) {
        if (left >= right - 1){
            return 0;
        }
        if (res[left][right] != -1){
            return res[left][right];
        }
        for (int i = left + 1; i < right; i++){
            int sum = val[left] * val[i] * val[right];
            sum += solve(left, i) + solve(i, right);
            res[left][right] = Math.max(res[left][right], sum);
        }
        return res[left][right];
    }

    public int maxCoins1(int[] nums) {
        int len = nums.length;
        int[][] res = new int[len + 2][len + 2];
        int[] val = new int[len + 2];
        val[0] = val[len + 1] = 1;
        for (int i = 1; i <= len; i++){
            val[i] = nums[i - 1];
        }
        for(int i = len - 1; i >= 0; i--){
            for (int j = i + 2; j <= len + 1; j++){
                for (int k = i + 1; k < j; k++){
                    int sum = val[i] * val[k] * val[j];
                    sum += res[i][k] + res[k][j];
                    res[i][j] = Math.max(res[i][j], sum);
                }
            }
        }
        return res[0][len + 1];
    }
}
