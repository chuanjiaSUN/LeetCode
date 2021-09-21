package dynamicPlan;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-21 11:43
 */
public class Exe647 {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; i++)
        {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l)==s.charAt(r))
            {
                l--;
                r++;
                ans++;
            }
        }
        return ans;
    }

    public int countSubstrings1(String s)
    {
        int n = s.length();
        int ans = 0;
        for (int l = 0; l < n; l++)
        {
            for (int len = 1; l + len - 1 < n; len++)
            {
                int left = l;
                int right = l + len - 1;
                while (left < right && s.charAt(left) == s.charAt(right))
                {
                    left++;
                    right--;
                }
                if (left >= right)
                {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**中心拓展*/
    public int countSubstrings2(String s)
    {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= 1; j++)
            {
                int l = i;
                int r = i + j;
                while (l >= 0 && s.charAt(l) == s.charAt(r))
                {
                    l--;
                    r++;
                    ans++;
                }
            }
        }
        return ans;
    }
    public int countSubstrings4(String s)
    {
        int ans = 0;
        int n = s.length();
        for (int center = 0; center < 2 * n - 1; center++)
        {
            int left  = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < n && s.charAt(left)==s.charAt(right))
            {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    /**动规*/
    public int countSubstrings3(String s)
    {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        for (int j = 0; j < n; j++)
        {
            for (int i = 0; i <= j; i++)
            {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]))
                {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
