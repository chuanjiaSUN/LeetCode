package String.day05;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-23 13:27
 */
public class exercise38 {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++)
        {
            s = describe(s);
        }
        return s;
    }

    private String describe(String s) {
        StringBuffer res = new StringBuffer();
        if (s.length() == 1)
        {
            res.append("1");
            res.append(s);
        }
        int num = 1;
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == s.charAt(i-1))
            {
                num += 1;
                if ( i == s.length() - 1)
                {
                    res.append(num);
                    res.append(s.charAt( i - 1));
                }
            }else
            {
                res.append(num);
                res.append(s.charAt(i - 1));
                num = 1;
                if (i == s.length() - 1)
                {
                    res.append(num);
                    res.append(s.charAt(i));
                }
            }
        }
        return res.toString();
    }
}
