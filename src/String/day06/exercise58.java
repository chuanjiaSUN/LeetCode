package String.day06;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-24 11:24
 */
public class exercise58 {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int i = length - 1;
        int ans = 0;
        while (i >0 && s.charAt(i) == ' ')
        {
            i--;
        }
        while (i >=0 && s.charAt( i ) != ' ')
        {
            ans++;
        }
        return ans;
    }
}
