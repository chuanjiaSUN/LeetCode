package String.day06;

import sun.security.util.Length;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-24 16:45
 */
public class exercise65_prac {
    boolean hasDian = false;
    public boolean isNumber(String s)
    {
       for (int i = 0; i < s.length(); i++)
       {
            if ( s.charAt(i) == '.')
            {
                if (illegalSymbol(i, s)) return false;
            }else if (s.charAt(i) == '+' || s.charAt(i) == '-')
            {
                if ( i != 0) return false;
            }else if (s.charAt(i) == 'e' || s.charAt(i) == 'E')
            {
                return illegalSymbolE(i, s);
            }else if (illegalNum(i, s))
            {
                return false;
            }
       }
       return true;
    }

    private boolean illegalSymbol(int i, String s) {
        if (hasDian) return true;
        boolean res = true;
        if (i > 0 && !illegalNum( i - 1,s))
        {
            res = false;
        }
        if ( i < s.length() - 1 && !illegalNum(i+1, s))
        {
            res = false;
        }
        hasDian = true;
        return res;
    }

    private boolean illegalSymbolE(int i, String s) {
        if (i == 0 || s.charAt(i-1) == '+' || s.charAt(i-1) == '-' || i == s.length() - 1 ) return false;
        if (s.charAt(i+1) == '+' || s.charAt(i + 1) == '-') i++;
        if (++i == s.length()) return false;
        for (; i < s.length(); i++)
        {
            if (illegalNum(i,s))
            {
                return false;
            }
        }
        return true;
    }

    private boolean illegalNum(int i,String s) {
        if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9)
        {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        exercise65 e = new exercise65();
        boolean number = e.isNumber("32.e-80123");
        System.out.println(number);
    }

}
