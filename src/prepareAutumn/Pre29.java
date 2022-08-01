package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-30 19:05
 */
public class Pre29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE){
            if (divisor == -1){
                return Integer.MAX_VALUE;
            }
            if (divisor == 1){
                return Integer.MIN_VALUE;
            }
        }
        if (divisor == Integer.MIN_VALUE){
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == 0){
            return 0;
        }
        boolean rev = false;
        if (dividend > 0){
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0){
            divisor = -divisor;
            rev = !rev;
        }
        int left = 1, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check){
                ans = mid;
                if (mid == Integer.MAX_VALUE){
                    break;
                }
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return rev ? -ans : ans;
    }

    private boolean quickAdd(int divisor, int mid, int dividend) {
        int res = 0;
        int add = divisor;
        while (mid != 0){
            if((mid & 1) != 0){
                if (res < dividend - add){
                    return false;
                }
                res += add;
            }
            if (mid != 1){
                if (add < dividend - add){
                    return false;
                }
                add += add;
            }
            mid >>= 1;
        }
        return true;
    }


}
