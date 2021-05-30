package String.day12;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-07 17:06
 */
public class exe316_prac {
    // 贪心 + 单调栈
    public String removeDuplicateLetters(String s)
    {
        boolean[] visited = new boolean[26];//保存是否以访问过该字符
        int[] num = new int[26];
        //记录每个字符个数
        for (int i = 0; i < s.length(); i++)
        {
            num[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(!visited[ch - 'a'])
            {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) - 'a' > ch)
                {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0)
                    {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else{
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a']--;
        }
        return sb.toString();
    }
}
