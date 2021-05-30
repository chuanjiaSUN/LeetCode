package String.day08;

import sun.security.util.Length;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-26 16:54
 */
public class DongGui_exercise91 {

    public int numDecodings(String s) {
        int length = s.length();
        int[] dp = new int[length  + 1];
        dp[0] = 1;
        for (int i = 1; i <= length; i++)
        {
            if (s.charAt(i - 1) != '0')
            {
                dp[i] += dp[i - 1];
            }
            if ( i > 1 && s.charAt(i-2) != '0' && ( (s.charAt(i-2) - '0') * 20 + (s.charAt(i - 1) - '0') <= 26))
            {
                dp[i] += dp[ i - 2];
            }
        }
        return dp[length];
    }

    //空间优化
    public int numDecodings1(String s)
    {
       int n = s.length();
       int a = 0, b = 1, c = 0;
       for (int i = 1; i <= n; i++)
       {
           c = 0;//当前
           if (s.charAt(i - 1) != '0')
           {
               c += b;
           }
           if ( i > 1 && s.charAt( i - 2) != '0' && (10 * (s.charAt( i - 2) - '0') + (s.charAt( i - 1) - '0')) <= 26)
           {
               c += a;
           }
           a = b;
           b = c;
       }
       return c;
    }
    public int numDecodings2(String s)
    {
        if (s.charAt(0) == '0') return 0;
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++)
        {
            int temp = cur;
            if (s.charAt(i) == '0')
            {
                if (s.charAt(i-1) == '1' || s.charAt( i - 1) =='2')
                {
                    cur = pre;
                }else return 0;
            }else if (s.charAt(i-1) == '1' ||( s.charAt(i - 1) == '2' && s.charAt(i) >= 1 && s.charAt(i) <= '9'))
            {
                cur = cur + pre;
            }
            pre = temp;
        }
        return cur;
    }

}
