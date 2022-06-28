package prepareAutumn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-28 21:44
 */
public class Pre169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int ans = 0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > count){
                ans = num;
                count = map.get(num);
            }
        }
        return ans;
    }
}
