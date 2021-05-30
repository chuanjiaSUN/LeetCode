package Arrays.day03;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *

 * @create 2021-03-08 19:08
 */
public class exercise16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int answer = 10000;
        for(int first=0;first<length;first++){
            if(first>0 && nums[first] == nums[first-1]){
                continue;
            }
            int second = first +1,third = length - 1;
            while (second<third){
                int sum = nums[first] + nums[second] + nums[third];

                if(Math.abs(sum-target)<Math.abs(answer-target)){
                    answer = sum;
                }

                if(sum == target){
                    return target;
                }
                if(sum-target>0){
                    third--;
                    while(third>second && nums[third]==nums[third+1]){
                        third--;
                    }
                }else{
                    second++;
                    while (second<third && nums[second]==nums[second-1]){
                        second++;
                    }
                }
            }
        }
        return answer;
    }
}
