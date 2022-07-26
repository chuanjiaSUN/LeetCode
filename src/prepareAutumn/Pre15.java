package prepareAutumn;

import sun.management.Sensor;

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


    /**
     * practice
     * */
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;

        for (int first = 0; first < len - 2; first++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int target = -nums[first];

            int third = len - 1;
            for(int second = first + 1; second < len - 1; second++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if (second == third){
                    break;
                }
                if (nums[second] + nums[third] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }
}
