package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-24 21:31
 */
public class Pre121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }else if (prices[i] - min > ans){
                ans = prices[i] - min;
            }
        }
        return ans;
    }
}
