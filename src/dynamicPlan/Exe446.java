package dynamicPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-17 11:09
 */
public class Exe446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int len = nums.length;
        Map<Long, Integer>[] f = new Map[len];
        for (int i = 0; i < len; i++)
        {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < i; j++)
            {
                Long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt  +1);
            }
        }
        return ans;
    }
}
