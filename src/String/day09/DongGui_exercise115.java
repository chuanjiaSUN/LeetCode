package String.day09;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-27 11:38
 */
public class DongGui_exercise115 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0 ; i <= m; i++)
        {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (s.charAt( i ) == t.charAt( j ))
                {
                    dp[i][j] = dp[ i + 1 ] [ j + 1 ] + dp[i + 1][j];
                }else{
                    dp[i][j] = dp[ i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public int numDistinct1(String s, String t)
    {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i < t.length() + 1; i++)
        {
            for (int j = 1; j < s.length() + 1; j++)
            {
                if (t.charAt( i - 1) == s.charAt( j - 1))
                {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        DongGui_exercise115 e =new DongGui_exercise115();
        int i = e.numDistinct("rabbbit", "rabbit");
        System.out.println(i);
    }
}
