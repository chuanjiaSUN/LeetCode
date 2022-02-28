package num100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-27 11:02
 */
public class Exe128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        int longSteak = 0;
        for (int num : nums){
            if (!set.contains(num - 1)){
                int curNum = num;
                int curSteak = 1;

                while (set.contains(curNum + 1)){
                    curNum++;
                    curSteak++;
                }

                longSteak = Math.max(longSteak, curSteak);
            }
        }
        return longSteak;
    }
}
