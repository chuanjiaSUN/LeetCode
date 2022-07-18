package prepareAutumn;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-12 23:27
 */
public class Pre561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2){
            ans += (nums[i]);
        }
        return ans;
    }
}
