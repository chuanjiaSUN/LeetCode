package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-22 15:00
 */
public class Exe678 {
    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == '*')
            {
                dp[i][i] = true;
            }
        }
        for (int i = 1; i < n; i++)
        {
            char c1  = s.charAt(i - 1), c2 = s.charAt(i);
            dp[i - 1][i] = (c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*');
        }
        for (int i = n - 3; i >= 0; i--)
        {
            char c1 = s.charAt(i);
            for (int j = i + 2; j < n; j++)
            {
                char c2 = s.charAt(j);
                if ((c1 == '(' || c1 == '*') && (c2 == ')' || c2 == '*'))
                {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (int k = i; k < j && !dp[i][j]; k++)
                {
                    dp[i][j] = dp[i][k] && dp[k + 1][j];
                }
            }
        }
        return dp[0][n - 1];
    }

    /**动规
     * f[i][j]表示前i个字符能否与j个右括号成合法序列
     * */
    public boolean checkValidString2(String s)
    {
        int n = s.length();
        boolean[][] f = new boolean[n + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++)
        {
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++)
            {
                if (c == '(')
                {
                    if (j - 1 >= 0)
                    {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }else if (c == ')')
                {
                    if (j + 1 <= i)
                    {
                        f[i][j] = f[i - 1][j + 1];
                    }
                }else{
                    f[i][j] = f[i - 1][j];
                    if (j - 1 >= 0)
                    {
                        f[i][j] |= f[i - 1][j - 1];
                    }
                    if (j + 1 <= i)
                    {
                        f[i][j] |= f[i - 1][j + 1];
                    }
                }
            }
        }
        return f[n][0];
    }
    /**贪心*/
    public boolean checkValidString1(String s)
    {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if (c == '(')
            {
                minCount++;
                maxCount++;
            }else if (c == ')')
            {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0)
                {
                    return false;
                }
            }else{
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
    public boolean checkValidString3(String s)
    {
        int l = 0, r = 0;
        for (char c : s.toCharArray())
        {
            if (c == '(')
            {
                l++;r++;
            }else if (c == ')')
            {
                l--;r--;
            }else{
                l--;r++;
            }
            l = Math.max(l, 0);
            if (l > r)
            {
                return false;
            }
        }
        return l == 0;
    }

}
