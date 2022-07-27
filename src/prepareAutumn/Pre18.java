package prepareAutumn;

import Interview.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-27 21:31
 */
public class Pre18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len - 3; first++){
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            for (int second = first + 1; second < len - 2; second++){
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }

                int fourth = len - 1;
                int third = second + 1;
                while (third < fourth){
                    int temp = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (temp == target){
                        List<Integer> arr = new ArrayList<>();
                        arr.add(nums[first]);
                        arr.add(nums[second]);
                        arr.add(nums[third]);
                        arr.add(nums[fourth]);
                        ans.add(new ArrayList<>(arr));
                        while (third < fourth && nums[third] == nums[third + 1]) {
                            third++;
                        }
                        third++;
                        while (third < fourth && nums[fourth] == nums[fourth - 1]) {
                            fourth--;
                        }
                        fourth--;

                    }else if (temp < target){
                        third++;
                    }else{
                        fourth--;
                    }
                }
            }
        }
        return ans;
    }
}
