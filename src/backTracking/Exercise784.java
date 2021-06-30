package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-30 12:37
 */
public class Exercise784 {
    List<String> ans;
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        int len = s.length();
        if (len == 0 || s == null)
        {
            return ans;
        }
        char[] charArray = s.toCharArray();
        backTrack(charArray, len, 0);
        return ans;
    }

    private void backTrack(char[] charArray, int len, int index) {
        if (index == len)
        {
            ans.add(new String(charArray));
            return;
        }
        backTrack(charArray, len, index + 1);
        if (check(charArray[index]))
        {
            charArray[index] = change(charArray, index);
            backTrack(charArray, len, index);
        }
    }

    private char change(char[] charArray, int i) {
        char temp = charArray[i];
        if (temp >= 'a' && temp <= 'z')
        {
            return Character.toUpperCase(temp);
        }else{
            return Character.toLowerCase(temp);
        }
    }

    private boolean check(char c) {
        if (c >= 'a' && c <= 'z')
        {
            return true;
        }
        if (c >= 'A' && c <= 'Z')
        {
            return true;
        }
        return false;
    }
}
