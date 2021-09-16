package dynamicPlan;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-16 11:22
 */
public class Exe435 {
    /**动规*/
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null)
        {
            return 0;
        }
        int len = intervals.length;
        if (len == 0)
        {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] f = new int[len];
        Arrays.fill(f, 1);
        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (intervals[j][1] <= intervals[i][0])
                {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return len - Arrays.stream(f).max().getAsInt();
    }
    /**贪心*/
    public int eraseOverlapIntervals1(int[][] intervals)
    {
        if (intervals.length == 0)
        {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; i++)
        {
            if (intervals[i][0] >= right)
            {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }
}
