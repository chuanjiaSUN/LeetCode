package greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-27 11:11
 */
public class Exe15 {
    /**双指针*/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        //枚举a
        for (int first = 0; first < n; first++)
        {
            if (first > 0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            //枚举b
            for (int second = first + 1; second < n; second++)
            {
                if (second > first + 1 && nums[second] == nums[second - 1])
                {
                    continue;
                }
                //枚举c
                while (second < third && nums[second] + nums[third] > target)
                {
                    third--;
                }
                //指针重合
                if (second == third)
                {
                    break;
                }
                if (nums[second] + nums[third] == target)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum1(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
        {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++)
        {
            if (nums[first] > 0)
            {
                break;
            }
            if (first > 0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            int second = first + 1;
            int third = n - 1;
            while (second < third)
            {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                    //去重
                    while(second < third && nums[second] == nums[second + 1])
                    {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1])
                    {
                        third--;
                    }
                    //用完了，移动指针
                    second++;
                    third--;
                }else if (sum > 0)
                {
                    third--;
                }else if (sum < 0)
                {
                    second++;
                }
            }
        }
        return ans;
    }

}
