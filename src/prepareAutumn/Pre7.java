package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-24 20:54
 */
public class Pre7 {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            if(ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10){
                return 0;
            }
            int tail = x % 10;
            ans = ans * 10 + tail;
            x = x / 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-11 % 10);
        System.out.println(-11 / 10);
    }
}
