package prepareAutumn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-12 23:06
 */
public class Pre560 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, 1);
        for(int i = 0; i < n; i++){
            pre += nums[i];
            if(map.containsKey(pre - k)){
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
