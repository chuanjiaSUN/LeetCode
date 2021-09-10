package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-10 11:25
 */
public class Exe375 {
    public static void main(String[] args) {
        Exe375 exe375 = new Exe375();
        int moneyAmount = exe375.getMoneyAmount(10);
        System.out.println(moneyAmount);
    }
    public int calculate(int low, int high) {
        if (low >= high){
            return 0;
        }
        int minres = Integer.MAX_VALUE;
        for (int i = (low + high ) / 2; i <= high; i++) {
            int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));
            minres = Math.min(res, minres);
        }
        return minres;
    }
    public int getMoneyAmount(int n) {
        return calculate(1, n);
    }


    /**法2 动规*/
    public int getMoneyAmount1(int n)
    {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++)
        {
            for (int start = 1; start <= n - len + 1; start++)
            {
                int minRes = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++)
                {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minRes = Math.min(res, minRes);
                }
                dp[start][start + len - 1] = minRes;
            }
        }
        return dp[1][n];
    }
}
