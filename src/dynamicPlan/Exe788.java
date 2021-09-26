package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-26 12:40
 */
public class Exe788 {
    public int rotatedDigits(int n) {
        char[] A = String.valueOf(n).toCharArray();
        int k = A.length;

        int[][][] memo = new int[k + 1][2][2];
        memo[k][0][1] = memo[k][1][1] = 1;
        for (int i = k - 1; i >= 0; i--)
        {
            for (int eqf = 0; eqf <= 1; eqf++)
            {
                for (int invf = 0; invf <= 1; invf++)
                {
                    int ans = 0;
                    for (char d = '0'; d <= (eqf == 1 ? A[i] : '9'); d++)
                    {
                        if (d == '3' || d == '4' || d== '7')
                        {
                            continue;
                        }
                        boolean invo = (d == '2' || d == '5' || d == '6' || d == '9');
                        ans += memo[i + 1][d == A[i] ? eqf : 0][invo ? 1 : invf];
                    }
                    memo[i][eqf][invf] = ans;
                }
            }
        }
        return memo[0][1][0];
    }

    public int rotatedDigits1(int n)
    {
        int[] dp = new int[n + 1];
        // 0代表好数， 1代表有效但不是好数，2代表无效
        dp[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            int pre = dp[i / 10];
            if (pre == 2)
            {
                dp[i] = 2;
            }else if (pre == 1){
                int rest = i % 10;
                if (rest == 2 || rest == 5 || rest == 6 || rest == 9)
                {
                    dp[i] = 0;
                }else if (rest == 3 || rest == 4 || rest == 7)
                {
                    dp[i] = 2;
                }else{
                    dp[i] = 1;
                }
            }else{
                int rest = i % 10;
                if (rest == 3 || rest == 4 || rest == 7)
                {
                    dp[i] = 2;
                }else{
                    dp[i] = 0;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++)
        {
            if (dp[i] == 0)
            {
                ans++;
            }
        }
        return ans;
    }
}
