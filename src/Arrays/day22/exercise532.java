package Arrays.day22;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-28 10:15
 */
public class exercise532 {
    public int findPairs(int[] nums, int k) {
        int length = nums.length;
        if(length == 0) return 0;
        Set<Integer> saw = new HashSet<>();
        Set<Integer> diff = new HashSet<>();
        for(int i=0;i<length;i++)
        {
            if(saw.contains(nums[i] - k))
            {
                diff.add(nums[i] - k);
            }
            if(saw.contains(nums[i] + k))
            {
                diff.add(nums[i]);
            }
            saw.add(nums[i]);
        }
        return diff.size();
    }

    public static void main(String[] args) {
        int[] nums = {6,3,5,7,2,3,3,8,2,4};
        exercise532 e = new exercise532();
        int pairs = e.findPairs(nums, 2);
        System.out.println(pairs);

    }
}
