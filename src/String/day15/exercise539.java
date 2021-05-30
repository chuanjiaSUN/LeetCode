package String.day15;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-13 9:49
 */
public class exercise539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 1440) return 0;

        int[] arr = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++)
        {
            arr[i] = calMinute(timePoints.get(i));
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++)
        {
            ans = Math.min(ans, arr[i] - arr[i-1]);
            if (ans == 0) return 0;
        }
        return Math.min(ans, 1440 + arr[0] - arr[arr.length - 1]);
    }

    private int calMinute(String s) {
        return (s.charAt(0) - '0') * 600 + (s.charAt(1) - '0') * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
    }
}
