package String.day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-26 14:34
 */
public class exercise76_prac {
    //滑动窗口，记录窗口内字符及个数，满足条件时缩小窗口
    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();
    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++)
        {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;
        int ansL = -1, ansR = -1;
        int len = Integer.MAX_VALUE;
        int sLen = s.length();
        while ( r < sLen)
        {
            r++;
            if (ori.containsKey( s.charAt(r)))
            {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while ( check() && l <= r)
            {
                if ( r - l + 1 < len)
                {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l)))
                {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                l++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (cnt.getOrDefault(key, 0) < value)
            {
                return false;
            }
        }
        return true;
    }
}
