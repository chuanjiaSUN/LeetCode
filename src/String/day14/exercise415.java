package String.day14;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-11 12:40
 */
public class exercise415 {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int rest = 0;
        int i = m, j = n;
        StringBuffer ans = new StringBuffer();
        while (i >0 || j >0)
        {
            int x1 = i > 0 ? num1.charAt( i - 1) - '0' : 0;
            int x2 = j > 0 ? num2.charAt( j - 1) - '0' : 0;
            ans.append((x1 + x2 + rest) % 10);
            rest = (x1 + x2 + rest) / 10;
            i--;
            j--;
        }
        if (rest != 0)
        {
            ans.append(rest);
        }
        return ans.reverse().toString();
    }
}
