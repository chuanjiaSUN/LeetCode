package prepareAutumn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-10 22:42
 */
public class Pre3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int ans = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int right = -1;
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 < len && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            if (right - left + 1 > ans) {
                ans = right - left + 1;
            }
        }
        return ans;
    }

    /**
     * practice
     */
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int ritht = -1;
        int len = s.length();
        int ans = 0;
        for (int left = 0; left < len; left++){
            if (left != 0){
                set.remove(s.charAt(left - 1));
            }
            while (ritht + 1 < len && !set.contains(s.charAt(ritht  + 1))){
                set.add(s.charAt(ritht + 1));
                ritht++;
            }
            if (ritht - left  +1 > ans){
                ans = ritht - left + 1;
            }
        }
        return ans;
    }
    /**
     * practice
     * */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int right = -1;
        int ans = 0;
        for (int left = 0; left < len; left++){
            if (left > 0){
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 < len && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right++;
            }
            if (right - left + 1 > ans){
                ans = right - left + 1;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        int len = s.length();
        int ans = 0;
        int right = -1;
        Set<Character> set = new HashSet<>();
        for (int left = 0; left < len; left++){
            if (left > 0){
                set.remove(s.charAt(left - 1));
            }
            while (right + 1 < len && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right += 1;
            }
            if (right - left + 1 > ans){
                ans = right - left + 1;
            }
        }
        return ans;
    }
}
