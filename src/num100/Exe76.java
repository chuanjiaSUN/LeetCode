package num100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-21 16:47
 */
public class Exe76 {
    /**滑动窗口*/
    Map<Character, Integer> original = new HashMap<>();
    Map<Character, Integer> path = new HashMap<>();
    public String minWindow(String s, String t) {
        int m = s.length() ,n = t.length();
        for (int i = 0; i < n; i++){
            original.put(t.charAt(i), original.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;

        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < m){
            r++;
            if (r < m && original.containsKey(s.charAt(r))){
                path.put(s.charAt(r), path.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r){
                if (r - l + 1 <= len){
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (original.containsKey(s.charAt(l))){
                    path.put(s.charAt(l), path.getOrDefault(s.charAt(l), 0 ) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> next : original.entrySet()) {
            Character key = next.getKey();
            Integer value = next.getValue();
            if (path.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }
}
