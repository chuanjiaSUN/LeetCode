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

    /**
     * 2023-3-6
     * */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> vis = new HashSet<>();
        int maxLength = 0;
        int right = -1;
        int length = s.length();
        for (int left = 0; left < length; left++){
            if (left > 0){
                vis.remove(s.charAt(left - 1));
            }
            while (right + 1 < length && !vis.contains(s.charAt(right + 1))){
                vis.add(s.charAt(right + 1));
                right++;
            }
            if (right - left + 1 > maxLength){
                maxLength = right - left + 1;
            }
        }
        return maxLength;
    }
}
