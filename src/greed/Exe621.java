package greed;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-15 12:20
 */
public class Exe621 {
    /**桶*/
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequence = new HashMap<>();
        int maxExec = 0;
        for (char c : tasks)
        {
            int exec = frequence.getOrDefault(c, 0) + 1;
            frequence.put(c, exec);
            maxExec = Math.max(maxExec, exec);
        }
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = frequence.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet)
        {
            int value = entry.getValue();
            if (value == maxExec)
            {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * ( n + 1) + maxCount, tasks.length);
    }
}
