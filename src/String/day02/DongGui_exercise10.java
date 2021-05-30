package String.day02;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-20 10:40
 */
public class DongGui_exercise10 {

    //动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1 ][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                //匹配 s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
                //不匹配字符，将该组合扔掉，不再进行匹配。
                if (p.charAt(j - 1) == '*')
                {
                    f[i][j] = f[i][j - 2];// j 前面那个没匹配上
                    if (matches(s, p, i, j - 1))
                    {
                        f[i][j] = f[i][j - 2] || f[i - 1][j];// j-1 那个与i匹配上了, p中*前面的字符在s中出现多次或只出现1次
                    }
                }else{
                    if (matches(s, p, i, j))
                    {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0)
        {
            return false;
        }
        if (p.charAt(j - 1) == '.' ) {
            return true;
        }
        return s.charAt(i - 1) == p.charAt( j - 1);
    }
}
