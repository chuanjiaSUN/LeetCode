package prepareAutumn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-24 22:09
 */
public class Pre136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : nums){
            if (map.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}
