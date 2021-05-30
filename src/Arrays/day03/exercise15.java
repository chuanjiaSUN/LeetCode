package Arrays.day03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]

 * @create 2021-03-08 16:13
 */

public class exercise15 {

    //先排序后，枚举，可以避免重复
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        QuickSort(nums,0,length-1);

        List<List<Integer>> answer = new ArrayList<>();
        //枚举a
        for(int first=0;first<length;first++){
            if(first>0 && nums[first] == nums[first-1]){
            //需要和上一次枚举的不同
                continue;
            }
            int third = length - 1;
            int target = -nums[first];
            //枚举b
            for(int second = first + 1;second<length;second++){
                if(second>(first+1) && nums[second] == nums[second-1]){
                    continue;
                }
                //枚举c
                while (second<third && nums[third]+nums[second] > target){
                    third--;
                }
                //如果指针重合，随着b后续增加，不会在满足a+b+c = 0 可退出循环
                if(second == third){
                    break;
                }
                if(nums[second]+nums[third] == target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    answer.add(res);
                }
            }
        }
        return answer;
    }

    public void QuickSort(int[] nums,int low,int high){

        int pivot;
        if(low < high){
            pivot = pivotKey(nums,low,high);

            QuickSort(nums,low,pivot-1);
            QuickSort(nums,pivot+1,high);
        }

    }

    public int pivotKey(int[] nums,int low,int high){
        int pivotKey;
        pivotKey = nums[low];
        while( low < high){
            while(low<high && nums[high]>=pivotKey){
                high--;
            }
            swap(nums,low,high);
            while(low<high && nums[low]<=pivotKey){
                low++;
            }
            swap(nums,low,high);
        }
        return low;
    }

    public void swap(int[]nums,int l,int h){
        int temp;
        temp = nums[h];
        nums[h] = nums[l];
        nums[l] = temp;
    }
}
