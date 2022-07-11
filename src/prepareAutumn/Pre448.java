package prepareAutumn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-11 22:18
 */
public class Pre448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int num : nums){
            set.add(num);
        }
        for (int i = 1; i <= n; i++){
            if (!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}
