package greed;


import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-14 11:37
 */
public class Exe502 {
    /**大根堆*/
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int curr = 0;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++)
        {
            while (curr < n && arr[curr][0] <= w)
            {
                pq.add(arr[curr][1]);
                curr++;
            }
            if (!pq.isEmpty())
            {
                w += pq.poll();
            }else{
                break;
            }
        }
        return w;
    }

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
