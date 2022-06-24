package prepareAutumn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-24 21:57
 */
public class Pre128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int size = 0;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums){
            if (!map.containsKey(num - 1)){
                int curNum = num;
                int curlen = 1;

                while (map.containsKey(curNum + 1)){
                    curlen++;
                    curNum++;
                }
                size = Math.max(size, curlen);
            }
        }
        return size;
    }
}
