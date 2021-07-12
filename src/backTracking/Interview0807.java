package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-12 22:00
 */
public class Interview0807 {
    List<String> ans;
    StringBuilder sb;
    boolean[] used;
    public String[] permutation(String s) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        used = new boolean[s.length()];
        backTrack(s.toCharArray(), 0);
        int size = ans.size();
        String[] res = new String[size];
        int i = 0;
        for (String str : ans)
        {
            res[i++] = str;
        }
        return res;
    }

    private void backTrack(char[] charArray, int start) {
        if (sb.length() == charArray.length)
        {
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++)
        {
            if (!used[i])
            {
                used[i] = true;
                sb.append(charArray[i]);
                backTrack(charArray, i + 1);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
