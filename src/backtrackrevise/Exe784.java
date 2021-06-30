package backtrackrevise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-30 14:16
 */
public class Exe784 {
    private static final char LOWER_LITTLE_BOUND = 'a';
    private static final char UPPER_LITTLE_BOUND = 'z';
    private static final char UPPER_LARGE_BOUND = 'Z';
    private static final char LOWER_LARGE_BOUND = 'A';
    List<String> ans;
    public List<String> letterCasePermutation(String s)
    {
        ans = new ArrayList<>();
        backTrack(s.toCharArray(), 0);
        return ans;
    }

    private void backTrack(char[] charArray, int start) {
        if (start == charArray.length)
        {
            ans.add(new String(charArray));
            return;
        }
        backTrack(charArray, start + 1);
        if (check(charArray[start]))
        {
            charArray[start] = changeChar(charArray, start);
            backTrack(charArray, start + 1);
        }
    }
    private void backTrack1(char[] charArray, int start) {
        if (start == charArray.length)
        {
            ans.add(new String(charArray));
            return;
        }
        backTrack1(charArray, start + 1);
        if (Character.isLetter(charArray[start]))
        {
            charArray[start] ^= 1 << 5;
            backTrack1(charArray, start + 1);
        }
    }

    private char changeChar(char[] charArray, int index) {
        if (charArray[index] >= LOWER_LITTLE_BOUND && charArray[index] <= UPPER_LITTLE_BOUND)
        {
            return Character.toUpperCase(charArray[index]);
        }else
        {
            return Character.toLowerCase(charArray[index]);
        }
    }

    private boolean check(char c) {
        if (c >= LOWER_LITTLE_BOUND && c <= UPPER_LITTLE_BOUND)
        {
            return true;
        }
        return c >= LOWER_LARGE_BOUND && c <= UPPER_LARGE_BOUND;
    }

}
