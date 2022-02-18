package num100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 15:51
 */
public class Exe15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int first = 0; first < len; first++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = -nums[first];
            int third = len - 1;

            for (int second = first + 1; second < len; second++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if (second == third){
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    ans.add(res);
                }
            }
        }
        return ans;
    }
}
