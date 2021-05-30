package String.day01;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-19 15:37
 */
public class DongGui_exercise5 {
    // 法1 动态规划
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2)
        {
            return s;
        }
        int maxLenth = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++)
        {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        //先枚举字串长度
        for (int l = 2; l <= length; l++)
        {
            //枚举左边界
            for (int i = 0; i < length; i++)
            {
                int j = l + i - 1;//右边界
                if ( j >= length)
                {
                    break;
                }
                if (chars[i] != chars[j])
                {
                    dp[i][j] = false;
                }else{
                    if (j - i < 3)
                    {
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLenth)
                {
                    maxLenth = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLenth);
    }

    //法2  从回文中心向两边扩展
    public String longestPalindrome1(String s)
    {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i ++)
        {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start)
            {
                start = i - ( len - 1) / 2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while ( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //法3 Manacher算法
    public String longestPalindrome2(String s)
    {
        int start = 0, end = -1;
        StringBuilder t = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++)
        {
            t.append(s.charAt(i));
            t.append('#');
        }
        s = t.toString();

        List<Integer> arm_len = new ArrayList<>();
        int right = -1, j = -1;//j 为回文中心， right为最大右边界
        for (int i = 0; i < s.length(); i++)
        {
            int cur_arm_len;
            if (right >= i)
            {
                int i_sym = j * 2 - i;// i关于中心的镜像点
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            }else{
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right)
            {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start)
            {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }
        StringBuffer ans = new StringBuffer();
        for (int i = start; i < end; i++)
        {
            if (s.charAt(i) != '#')
            {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return (right - left - 2)/2;
    }

    public static void main(String[] args) {
        String s = "abc";
        StringBuilder t = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++)
        {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        String str = t.toString();
        System.out.println(str);
    }
}
