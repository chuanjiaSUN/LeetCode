package String.day08;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-26 18:01
 */
public class exercise5_prac {
    //法1 动态规划
    public String longestPalindrome(String s)
    {
        int length = s.length();
        if (length < 2) return s;

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++)
        {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L <= length; L++)
        {
            for (int i = 0; i < length; i++)
            {
                int j = L + i - 1;//右边界
                if ( j >= length) break;

                if (charArray[i] != charArray[j])
                {
                    dp[i][j] = false;
                }else{
                    if (j - i < 3)
                    {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j-1];
                    }
                }
                //只要dp[i][L]==true， 子串为回文
                if (dp[i][j] && j - i + 1 > maxLen)
                {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    //法2 从中间向两边扩展
    public String longestPalindrome1(String s)
    {
        if (s == null || s.length() < 1) return "";
        int begin = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int len1 = expand(s, i, i);
            int len2 = expand(s,i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - begin)
            {
                begin = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(begin, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return right - left + 1 - 2;
    }

}
