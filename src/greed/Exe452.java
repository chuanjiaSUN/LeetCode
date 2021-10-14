package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-14 10:49
 */
public class Exe452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
        {
            return 0;
        }
        Arrays.sort(points, (a, b) ->{
            if (a[1] > b[1])
            {
                return 1;
            }else if (a[1] < b[1]){
                return -1;
            }else{
                return 0;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] ballon : points)
        {
            if (ballon[0] > pos)
            {
                pos = ballon[1];
                ans++;
            }
        }
        return ans;
    }
}
