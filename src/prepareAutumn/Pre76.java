package prepareAutumn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-21 22:25
 */
public class Pre76 {
    public String minWindow(String s, String t) {
        if (null == s || "".equals(s)){
            return "";
        }
        if (null == t || "".equals(t)){
            return "";
        }
        Map<Character, Integer> origin = new HashMap<>();
        Map<Character, Integer> path = new HashMap<>();
        for (char ch : t.toCharArray()){
            origin.put(ch, origin.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int len = s.length();
        for (int right = 0; right < len; right++){
            char ch = s.charAt(right);
            if (origin.containsKey(ch)){
                path.put(ch, path.getOrDefault(ch, 0) + 1);
            }
            while (left <= right && match(path, origin)){
                if (right - left + 1< ans){
                    ans = right - left + 1;
                    start = left;
                }
                if (origin.containsKey(s.charAt(left))){
                    path.put(s.charAt(left), path.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }

    private boolean match(Map<Character, Integer> path, Map<Character, Integer> origin) {
        for (Map.Entry<Character, Integer> entry : origin.entrySet()) {
            Character key = entry.getKey();
            if (path.getOrDefault(key, 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
