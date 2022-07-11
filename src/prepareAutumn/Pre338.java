package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-07 22:12
 */
public class Pre338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int cur = i;
            while (cur > 0){
                if ((cur & 1) > 0){
                    ans[i]++;
                    cur >>= 1;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

    public int[] countBits1(int n) {
        int[] dp = new int[n + 1];
        int high = 0;
        for (int i = 0; i <= n; i++){
            if ((i & (i - 1) ) == 0){
                high = i;
            }
            dp[i] = dp[i - high] + 1;
        }
        return dp;
    }
}
