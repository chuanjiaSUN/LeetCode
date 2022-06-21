package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-20 23:30
 */
public class Pre70 {
    public int climbStairs(int n) {
        int ans = 0;
        int pre = 1;
        int tail = 1;
        for(int i = 2; i <= n; i++){
            ans = pre + tail;
            pre = tail;
            tail = ans;
        }
        return ans;
    }
}
