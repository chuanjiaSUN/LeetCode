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
        if(s == null || s.length() == 0){
            return 0;
        }

        int ans = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int right = -1;
        for(int left = 0; left < s.length(); left++){
            if(left != 0){
                set.remove(s.charAt(left - 1));
            }
            while(right + 1 < len && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right++;
            }
            if(right - left + 1> ans){
                ans = right - left + 1;
            }
        }
        return ans;
    }
}
