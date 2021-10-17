package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-17 13:16
 */
public class Exe738 {
    public int monotoneIncreasingDigits(int n) {
        char[] strN = Integer.toString(n).toCharArray();
        int i = 1;
        int len = strN.length;
        while (i < len && strN[i - 1] <= strN[i])
        {
            i += 1;
        }
        if (i < len)
        {
            while ( i > 0 && strN[i - 1] > strN[i])
            {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for ( i += 1; i < len; i++)
            {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
