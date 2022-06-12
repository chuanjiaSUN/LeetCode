package prepareAutumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-12 21:19
 */
public class Pre15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int third = len - 1;
            int target = -nums[i];
            for (int j = i + 1; j < len; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while (j <  third && nums[j] + nums[third] > target){
                    third--;
                }
                if (j == third){
                    break;
                }
                if (nums[j] + nums[third] == target){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[third]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
