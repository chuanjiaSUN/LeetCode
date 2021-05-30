package String.day14;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-11 12:51
 */
public class exercise434 {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if ( (i==0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ')
            {
                ans++;
            }
        }
        return ans;
    }
}
