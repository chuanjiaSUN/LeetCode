package String.day06;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-24 9:31
 */
public class DongGui_exercise44 {

    // 法1 动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
        {
            if (p.charAt( i - 1) == '*')
            {
                dp[0][i] = true;
            }else{
                break;
            }
        }
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (p.charAt( j - 1) == '*')
                {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else if (p.charAt(j - 1) == '?' || s.charAt( i - 1) == p.charAt( j - 1))
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    //法2 贪心算法
    public boolean isMatch1(String s, String p)
    {
        int sRight = s.length();
        int pRight = p.length();
        //当模式p结尾不为星号时
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*')
        {
            if (charMatch(s.charAt( sRight - 1), p.charAt(pRight - 1)))
            {
                --sRight;
                --pRight;
            }else{
                return false;
            }
        }

        if (pRight == 0)
        {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;//表明开头还未匹配

        while (sIndex < sRight && pIndex < pRight)
        {
            if ( p.charAt( pIndex) == '*')
            {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            }else if (charMatch(s.charAt(sIndex), p.charAt(pIndex)))
            {
                sIndex++;
                pIndex++;
            }else if (sRecord != -1 && sRecord + 1 < sRight)//两个字符不匹配，需要重新在s中寻找子串
            {
                sRecord++;
                sIndex = sRecord;
                pIndex = pRecord;
            }else{
                return false;
            }
        }
        return allStarts(p, pIndex, pRight);
    }

    private boolean allStarts(String str, int left, int right) {
        for (int i = left;i < right; i++)
        {
            if (str.charAt( i ) != '*')
            {
                return false;
            }
        }
        return true;
    }

    private boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }
}
