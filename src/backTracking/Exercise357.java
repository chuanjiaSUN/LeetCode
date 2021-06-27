package backTracking;

import javafx.stage.PopupWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-27 11:58
 */
public class Exercise357 {
    int ans = 0;
    static final int NUM_COUNT = 9;
    public int countNumbersWithUniqueDigits(int n) {
        List<Integer> list = new ArrayList<>();
        backTrack(n, 0, list);
        return ans;
    }

    private void backTrack(int n, int index, List<Integer> list) {
       if (index == n)
       {
           ans++;
           return;
       }
       for (int i = 0; i <= NUM_COUNT; i++)
       {
           if (list.contains(i)){
               continue;
           }
           if (list.size() == 0 && i == 0)
           {
               backTrack(n, index + 1, list);
           }else{
               list.add(i);
               backTrack(n, index + 1, list);
               list.remove(list.size() - 1);
           }
       }
    }

    /**法2 动态规划
     * dp 数组代表前 i 位重复的个数
     * */
    public int countNumbersWithUniqueDigits1(int n)
    {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++)
        {
            double temp = 9 * Math.pow(10.0, i - 2);
            dp[i] = (int) ((dp[i - 1] * 10) + ((temp - dp[i - 1]) * (i - 1)));
        }
        int sum = 0;
        for(int i = 0; i < n + 1; i++)
        {
            sum += dp[i];
        }
        return (int) (Math.pow(10, n) - sum);
    }
}
