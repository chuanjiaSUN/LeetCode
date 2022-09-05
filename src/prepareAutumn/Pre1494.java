package prepareAutumn;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-26 16:48
 */
public class Pre1494 {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];
        for(int[] rel : relations){
            pre[rel[1] - 1] |= 1 << (rel[0] - 1);
        }
        int max = 1 << n;
        int[] dp = new int[max];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int learned = 0; learned < max; learned++){
            int waitStudy = 0;
            for (int i = 0; i < n; i++){
                if ((learned & 1 << i) != 0){
                    continue;//已经学了
                }
                if((pre[i] & learned) == pre[i]){
                    waitStudy |= 1 << i;
                }
            }
            /**
             * 遍历状态压缩子集
             * */
            //排除已经有的状态
            waitStudy = waitStudy & (~learned);
            for(int study = waitStudy; study > 0 ; study = (study - 1) & waitStudy){
                if(Integer.bitCount(study) > k){
                    continue;
                }
                dp[learned | study] = Math.min(dp[learned | study], dp[learned] + 1);
            }
        }
        return dp[max - 1];
    }
}
