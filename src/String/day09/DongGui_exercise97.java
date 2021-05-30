package String.day09;

import jdk.nashorn.internal.runtime.FindProperty;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-27 10:36
 */
public class DongGui_exercise97 {
    //动态规划
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if ( m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m + 1][n+ 1];
        dp[0][0] = true;
        for (int i = 1; i <= m && s1.charAt( i - 1) == s3.charAt( i - 1); i++)
        {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n && s2.charAt(i-1) == s3.charAt(i-1); i++)
        {
            dp[0][i] = true;
        }
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                dp[i][j] = (dp[i - 1][j] && s1.charAt( i - 1) == s3.charAt(i + j -1))
                        || (dp[i][j-1] && s2.charAt( j - 1) == s3.charAt( i + j - 1));
            }
        }
        return dp[m][n];
    }
    //滚动数组优化
    public boolean isInterleave1(String s1, String s2, String s3)
    {
        int n = s1.length();
        int m = s2.length();
        if (m + n != s3.length()) return false;
        boolean[] dp = new boolean[ m + 1 ];
        dp[0] = true;
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                int p = i + j - 1;
                if ( i > 0)
                {
                    dp[j] = dp[j] && s3.charAt(p) == s1.charAt( i - 1);//判断能否从上往下走
                }
                if ( j > 0)
                {
                    dp[j] = dp[j] || (dp[j - 1] && s3.charAt(p) == s2.charAt(j-1));//再从上往下走的基础上， 判断能否从左往右走， 或运算取 true的那一个结果
                }
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        DongGui_exercise97 e = new DongGui_exercise97();
        boolean interleave1 = e.isInterleave1("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave1);
    }
}
