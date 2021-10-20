package greed;

import java.util.TreeMap;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-20 14:34
 */
public class Exe846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand)
        {
            int temp = count.getOrDefault(card, 0);
            count.put(card, temp + 1);
        }
        while (count.size() > 0)
        {
            int first = count.firstKey();
            for (int card =  first; card < first + groupSize; card++)
            {
                if (!count.containsKey(card))
                {
                    return false;
                }
                int c = count.get(card);
                if (c == 1)
                {
                    count.remove(card);
                }else{
                    count.replace(card, c - 1);
                }
            }
        }
        return true;
    }
}
