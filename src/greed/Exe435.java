package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-12 11:51
 */
public class Exe435 {
    /**贪心*/
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null)
        {
            return 0;
        }
        Arrays.sort(intervals, (a, b) ->{
            return a[1] - b[1];
        });
        int ans = 1;
        int len = intervals.length;
        int right = intervals[0][1];
        for (int i = 1; i < len; i++)
        {
           if (intervals[i][0] >= right)
           {
               ans++;
               right = intervals[i][1];
           }
        }
        return len - ans;
    }
    /**DP*/
    public int eraseOverlapIntervals1(int[][] intervals)
    {
        if (intervals == null)
        {
            return 0;
        }
        Arrays.sort(intervals, (a, b) ->{
            return a[0] - b[0];
        });

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (intervals[j][1] <= intervals[i][0])
                {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
