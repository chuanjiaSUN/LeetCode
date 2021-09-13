package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 11:11
 */
public class Exe392 {
    /**双指针*/
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m)
        {
            if (s.charAt(i) == t.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /**动规*/
    public boolean isSubsequence1(String s, String t)
    {
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++)
        {
            f[m][i] = m;
        }

        for (int i = m - 1; i>=0; i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (t.charAt(i) == j + 'a')
                {
                    f[i][j] = i;
                }else{
                    f[i][j] = f[i + 1][j];
                }
            }
        }

        int add = 0;
        for (int i = 0; i < n; i++)
        {
            if (f[add][s.charAt(i) - 'a'] == m)
            {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
