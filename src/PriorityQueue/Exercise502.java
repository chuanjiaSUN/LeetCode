package PriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-14 12:01
 */
public class Exercise502 {
    public int findMaximizedCapital1(int k, int w, int[] profits, int[] capital)
    {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(new int[]{capital[i], profits[i]});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;

        while (k-- > 0)
        {
            while (idx < n && list.get(idx)[0] <= w)
            {
                queue.add(list.get(idx)[1]);
                idx++;
            }
            if (!queue.isEmpty())
            {
                w += queue.poll();
            }else{
                break;
            }
        }
        return w;
    }
}
