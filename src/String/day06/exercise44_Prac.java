package String.day06;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-24 10:26
 */
public class exercise44_Prac {

    //动态规划
    public boolean isMatch(String s, String p)
    {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
        {
            if (p.charAt(i - 1) == '*')
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
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else if (p.charAt( j - 1) == s.charAt( i - 1) || p.charAt( j - 1) == '?')
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    //贪心  寻找p中被星号隔开的所有子串，看它在s中能否匹配
    public boolean isMatch1(String s, String p)
    {
        int sRight = s.length();
        int pRight = p.length();

        //判断结尾能否匹配
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*')
        {
            if (charMatch(s.charAt( sRight - 1), p.charAt(pRight - 1)))
            {
                sRight--;
                pRight--;
            }else{
                return false;
            }
        }

        if (pRight == 0) return sRight == 0;

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;
        //开始从头在p中寻找被星号隔开的子串 能否 与 s中子串匹配
        while ( sIndex < sRight && pIndex < pRight)
        {
            if (p.charAt(pIndex) == '*')//依顺序找到p中被星号隔开的子串
            {
                pIndex++;
                sRecord = sIndex;
                pRecord = pIndex;
            }else if (charMatch(p.charAt(pIndex) , s.charAt(sIndex)))//匹配到子串中的相应符号
            {
                sIndex++;
                pIndex++;
            }else if (sRecord != -1 && sRecord + 1 < sRight)//未匹配到,但p中已经按顺序有了星号或者子串被匹配，在s中重新寻找 新子串的开头位置
            {
                sRecord++;
                sIndex = sRecord;
                pIndex = pRecord;
            }else{
                return false;
            }
        }
        return allMatch(p, pIndex, pRight);//匹配结束后，p没有匹配完，但s匹配完了，需要p以后的字符都为星号
    }

    private boolean allMatch(String p, int left, int right) {
        for (int i = left; i < right; i++)
        {
            if (p.charAt(i) != '*')
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
