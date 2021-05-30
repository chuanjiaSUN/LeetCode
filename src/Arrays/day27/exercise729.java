package Arrays.day27;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-03 14:37
 */
public class exercise729 {
    //暴力法
    class MyCalendar {

        List<int[]> calendar;
        public MyCalendar() {
            calendar = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for(int[] iv : calendar)
            {
                if(iv[0] < end && iv[1] > start) return false;
            }
            calendar.add(new int[]{start, end});
            return true;
        }
    }

    //法2 平衡树
    class MyCalendar1 {
        TreeMap<Integer, Integer> calendar;
        public MyCalendar1() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start),
                    next = calendar.ceilingKey(start);
            if((prev == null || (calendar.get(prev) )<=start) && (next == null || end <= next))
            {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }
}
