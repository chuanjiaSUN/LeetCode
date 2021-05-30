package String.day14;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-11 13:16
 */
public class exercise459 {
    //枚举
    public boolean repeatedSubstringPattern(String s) {
         int len = s.length();
         for (int i = 1; i * 2 <= len; i++)
         {
             if ( len % i == 0)
             {
                 boolean match = true;
                 for (int j = i; j < len; j++)
                 {
                     if (s.charAt(j) != s.charAt(j - i))
                     {
                         match = false;
                         break;
                     }
                 }
                 if (match)
                 {
                     return true;
                 }
             }
         }
         return false;
    }
    //KMP算法
    public boolean repeatedSubstringPattern1(String s)
    {
        return kmp(s + s , s);
    }

    private boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] next = new int[m];
        Arrays.fill(next, -1);
        //初始化模式串的next数组
        for (int i = 1; i < m; i++)
        {
            int j = next[i - 1];
            while ( j != -1 && pattern.charAt( j + 1) != pattern.charAt(i))
            {
                j = next[j];
            }
            if (pattern.charAt( j + 1) == pattern.charAt(i))
            {
                next[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n -1 ; i++)
        {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i))
            {
                match = next[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i))
            {
                match++;
                if (match == m - 1)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
