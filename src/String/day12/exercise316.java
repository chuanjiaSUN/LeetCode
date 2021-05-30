package String.day12;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-07 16:52
 */
public class exercise316 {
    //法1 贪心 + 单调栈
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++)
        {
            num[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();//做单调栈
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if ( !vis[ ch - 'a'])
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
            num[ch - 'a']--;
        }
        return sb.toString();
    }
}
