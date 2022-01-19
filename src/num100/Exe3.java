package num100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-01-19 15:36
 */
public class Exe3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> occur = new HashSet<>();
        int len = s.length();
        int ans = 0, rIdx = -1;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                occur.remove(s.charAt(i - 1));
            }
            while (rIdx + 1 < len && !occur.contains(s.charAt(rIdx + 1))) {
                occur.add(s.charAt(rIdx + 1));
                rIdx++;
            }
            ans = Math.max(ans, rIdx - i + 1);
        }
        return ans;
    }
}
