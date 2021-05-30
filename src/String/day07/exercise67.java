package String.day07;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-25 9:14
 */
public class exercise67 {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        StringBuffer sb = new StringBuffer();
        int rest = 0;
        while (m >= 0 || n >= 0)
        {
            int num1 = m > 0 ? a.charAt(m - 1) - '0' : 0;
            m--;
            int num2 = n > 0 ? b.charAt(n - 1) - '0' : 0;
            n--;
            int add = (num1 + num2 + rest) % 2;
            if (m >=0 || n >=0 || rest >0)
            {
                sb.append(add);
            }
            rest = (num1 + num2 + rest) / 2;
        }
        return sb.reverse().toString();
    }

    //
    public String addBinary1(String a, String b)
    {
        int m = a.length();
        int n = b.length();
        StringBuffer sb = new StringBuffer();
        int len = Math.max(m, n);
        int i = 0, carry = 0;
        while ( i < len)
        {
            int num1 = i < a.length() ? a.charAt( m - 1 - i ) - '0' : 0;
            int num2 = i < b.length() ? b.charAt( n - 1 - i) - '0' : 0;
            carry  = carry + num1 + num2;
            sb.append(carry % 2);
            carry /= 2;
            i++;
        }
        if (carry > 0)
        {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        exercise67 e = new exercise67();
        String s = e.addBinary1("11", "1");
        System.out.println(s);
    }
}
