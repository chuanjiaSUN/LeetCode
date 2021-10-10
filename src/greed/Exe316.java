package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-10 11:41
 */
public class Exe316 {
    /**贪心 + 单调栈*/
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++)
        {
            num[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a'])
            {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch)
                {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0)
                    {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else{
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
