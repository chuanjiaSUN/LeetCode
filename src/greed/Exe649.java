package greed;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-16 16:27
 */
public class Exe649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            if (senate.charAt(i) == 'R')
            {
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty())
        {
            int rIdx = radiant.poll(), dIdx = dire.poll();
            if (rIdx < dIdx)
            {
                radiant.offer(rIdx + n);
            }else{
                dire.offer(dIdx + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";

    }
}
