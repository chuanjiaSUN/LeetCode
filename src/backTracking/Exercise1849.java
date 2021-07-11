package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-11 14:28
 */
public class Exercise1849 {
    public boolean splitString(String s) {
        long t = 0;
        for (int i = 0; i < s.length() - 1; i++)
        {
            t = t * 10 + s.charAt(i) - '0';
            if (t > 10000000000L)
            {
                return false;
            }
            if (dfs(s, t, i + 1))
            {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String s, long pre, int index) {
        if (index == s.length())
        {
            return true;
        }
        long t = 0;
        for (int i = index; i < s.length(); i++)
        {
            t = t * 10 + s.charAt(i) - '0';
            if (t > 10000000000L){
                return false;
            }
            if (pre - 1 == t && dfs(s, t, i + 1))
            {
                return true;
            }
            if (t >= pre)
            {
                return false;
            }
        }
        return false;
    }
}
