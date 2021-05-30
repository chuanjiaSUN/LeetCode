package String.day02;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-20 11:25
 */
public class exercise10_prac {
    public boolean isMatch(String s, String p)
    {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;//表示空字符串匹配成功
        for (int i = 0; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (p.charAt( j - 1) == '*')
                {
                    f[i][j] = f[i][ j - 2];// p的 字符+ * 没有使用
                    if (matches(s, p, i, j - 1))
                    {
                        //p的 字符 + * 组合使用了 1次或多次
                        f[i][j] = f[i - 1][j] || f[i][j - 2];// p前面那一个匹配上了，s可与他只匹配多次或1次
                    }
                }else{
                    if (matches(s, p, i, j))
                    {
                        f[i][j] = f[i - 1][ j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if ( i == 0) return false;
        if ( p.charAt( j - 1) == '.')return true;
        return s.charAt( i - 1) == p.charAt( j - 1);
    }

}
