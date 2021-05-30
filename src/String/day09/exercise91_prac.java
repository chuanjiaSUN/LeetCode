package String.day09;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-27 13:25
 */
public class exercise91_prac {
    public int numDecodings(String s)
    {
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        for (int i = 1; i < length + 1; i++)
        {
            if (s.charAt( i - 1) != '0')
            {
                dp[i] += dp[ i - 1];//单独匹配
            }
            if ( i > 1 && ((s.charAt(i-2) - '0')*10 + (s.charAt( i - 1 ) - '0') < 26))
            {
                dp[i] += dp[i-2];
            }
        }
        return dp[length];
    }

    //滚动数组优化
    public int numDecodings1(String s)
    {
        int length = s.length();
        int pre = 1;// i - 1状态
        int prev = 0;// i - 2 状态
        int curr = 0;
        for (int i = 1; i < length + 1; i++)
        {
            curr = 0;
            if (s.charAt(i-1) != '0')
            {
                curr += pre;
            }
            if (i > 1 && ((s.charAt(i-2) - '0')*10 + (s.charAt( i - 1 ) - '0') < 26))
            {
                curr += prev;
            }
            prev = pre;
            pre = curr;
        }
        return curr;
    }
}
