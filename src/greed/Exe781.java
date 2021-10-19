package greed;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-19 19:20
 */
public class Exe781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : answers)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
        {
            int num = entry.getKey();
            int value = entry.getValue();
            ans += ((value / num + 1) * (num + 1));
        }
        return ans;
    }
}
