package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-08 23:08
 */
public class Pre50 {
    /**
     * 快速幂
     * */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long n) {
        if (n == 0){
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    private double quickMul1(double x, long n) {
        double ans = 1.0;
        double contribute = x;
        while (n > 0){
            if (n % 2 == 1){
                ans *= contribute;
            }
            contribute *= contribute;
            n /= 2;
        }
        return ans;
    }
    /**
     * practice
     * */
    public double myPow1(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        return n >= 0 ? quickMultiple(x, n) : 1.0 / quickMultiple(x, -n);
    }

    private double quickMultiple(double x, long n) {
        if (n == 0){
            return 1.0;
        }
        double y = quickMultiple(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
