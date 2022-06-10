package prepareAutumn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-10 21:51
 */
public class Pre1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        int len = nums.length;
        Map<Integer, Integer> numsList = new HashMap<>(len);

        int index = 0;
        for (int num : nums){
            if (numsList.containsKey(target - num)){
                return new int[]{numsList.get(target - num), index};
            }
            numsList.put(num, index);
            index++;
        }
        return new int[0];
    }
}
