package String.day14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-11 12:31
 */
public class exercise387 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) map.put(ch, -1);
            else map.put(ch, i);
        }
        int ans = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if (entry.getValue() != -1 && entry.getValue() < ans)
            {
                ans = entry.getValue();
            }
        }
        return ans == s.length() ? -1 : ans;
    }
}
