package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-18 11:35
 */
public class Exe509 {
    public int fib(int n) {
        if (n < 2)
        {
            return n;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
        {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    /**空间优化*/
    public int fib1(int n)
    {
        if (n < 2)
        {
            return n;
        }
        int p = 0, q = 1, cur = 0;
        for (int i = 2; i <= n; i++)
        {
            cur = p + q;
            p = q;
            q = cur;
        }
        return cur;
    }

}
