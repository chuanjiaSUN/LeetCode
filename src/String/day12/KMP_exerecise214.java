package String.day12;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-06 17:23
 */
public class KMP_exerecise214 {
    //找出S的最长前缀回文串，剩余的为需要添加的长度

    //法1、 KMP算法
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
//        Arrays.fill(fail, - 1);
        for (int  i = 1, j = 0; i < n; i++)
        {
            while ( j > 0 && s.charAt( j + 1) != s.charAt(i))
            {
                j = fail[j - 1];
            }
            if (s.charAt( j ) == s.charAt(i))
            {
                j++;
            }
            fail[i] = j;
        }
        int best = 0;
        for (int i = n - 1; i >=0; i--)
        {
            while (best >0 && s.charAt(best ) != s.charAt(i))
            {
                best = fail[best];
            }
            if (s.charAt(best ) == s.charAt(i))
            {
                best++;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }

//    一般来说，我们选取一个大于字符集大小（即字符串中可能出现的字符种类的数目）的质数作为base，再选取一个在字符串长度平方级别左右的质数作为mod，产生哈希碰撞的概率就会很低。
    //法2 字符串哈希
    public String shortestPalindrome1(String s)
    {
        int n = s.length();
        int base = 131, mod = 1000000007;
        int left = 0, right = 0, mul = 1;
        int best = -1;
        for (int i = 0; i < n; i++)
        {
            left = (int)(((long)left * base + s.charAt(i)) % mod) ;
            right = (int)((right + (long)mul * s.charAt(i)) % mod);
            if (left == right)
            {
                best = i;
            }
            mul = (int)((long)mul * base % mod);
        }
        String add = ( best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        return ans.append(s).toString();
    }
}
