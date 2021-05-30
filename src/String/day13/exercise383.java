package String.day13;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-10 15:12
 */
public class exercise383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++)
        {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++)
        {
            char ch = ransomNote.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0)
            {
                map.put(ch, map.get(ch) - 1);
            }else return false;
        }
        return true;
    }
}
