package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-14 11:16
 */
public class Exe455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;

        int ans = 0;
        for (int i = 0, j = 0; i < n && j < m; i++, j++)
        {
            while (j < m && g[i] > s[j])
            {
                j++;
            }
            if (j < m)
            {
                ans++;
            }
        }
        return ans;
    }
}
