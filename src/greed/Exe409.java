package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-12 11:44
 */
public class Exe409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++)
        {
            count[s.charAt(i)]++;
        }

        int ans = 0;
        for (int v : count)
        {
            ans += (v/2) * 2;
            if (v % 2 == 1 && ans % 2 == 0)
            {
                ans++;
            }
        }
        return ans;
    }
}
