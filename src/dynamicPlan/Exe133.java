package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-07 11:07
 */
public class Exe133 {
    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; k++)
        {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(0, n % (mulk * 10) - mulk + 1), mulk);
            mulk *= 10;
        }
        return ans;
    }
}
