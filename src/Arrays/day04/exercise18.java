package Arrays.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [], target = 0
 * 输出：[]
 * @create 2021-03-09 9:21
 */
public class exercise18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        ArrayList<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        int first;

        if(length==0||length<4){
            return null;
        }

        for(first=0;first<length-3;first++){
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
            if(nums[first]+nums[first+1]+nums[first+2]+nums[first+3]>target){
                break;
            }
            if(nums[first]+nums[length-3]+nums[length-2]+nums[length-1]<target){
                continue;
            }
            int deal = target - nums[first];
            int second,third,fourth;
            for(second=first+1;second<length-2;second++){
                if(second>first+1 && nums[second]==nums[second-1]){
                    continue;
                }
                if(nums[first]+nums[second]+nums[second+1]+nums[second+2]>target){
                    break;
                }
                if(nums[first]+nums[second]+nums[length-2]+nums[length-1]<target){
                    continue;
                }
                third = second + 1;
                fourth=length-1;
                while(third<fourth){
                    int sum = nums[second] + nums[third] + nums[fourth];

                    if(sum == deal){
                        ArrayList<Integer> result = new ArrayList<>();
                        result.add(nums[first]);
                        result.add(nums[second]);
                        result.add(nums[third]);
                        result.add(nums[fourth]);
                        list.add(result);
                        while (third<fourth && nums[third] == nums[third+1]){
                            third++;
                        }
                        third++;
                        while(third<fourth && nums[fourth] == nums[fourth-1]){
                            fourth--;
                        }
                        fourth--;
                    }

                    if(sum>deal){
                        fourth--;
                    }
                    if(sum<deal){
                        third++;
                    }


                }
            }
        }

        return list;
    }




    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        exercise18 e = new exercise18();
        List<List<Integer>> lists = e.fourSum(nums, 0);
        System.out.println(lists);
    }
}
