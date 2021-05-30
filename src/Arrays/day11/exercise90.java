package Arrays.day11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]

 * @create 2021-03-17 14:37
 */
public class exercise90 {
    //回溯法
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        getSub(nums,0,res,ans);
        return ans;
    }

    private void getSub(int[] nums, int start, List<Integer> res, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(res));
        for(int i=start;i<nums.length;i++)
        {
            if(i>start && nums[i]==nums[i-1])
            {
                continue;
            }
            res.add(nums[i]);
            getSub(nums,i+1,res,ans);
            res.remove(res.size()-1);
        }
    }

    //法2 迭代法 遍历每一个解集，出现重复数字时往每一个重复数字加各一个
    public List<List<Integer>> subsetsWithDup1(int[] nums){
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(res);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int dupCount = 0;//记录重复数字
            while(((i+1)<nums.length) &&nums[i]==nums[i+1])
            {
                dupCount++;
                i++;
            }
            int ansNum = ans.size();//解集个数
            for(int j=0;j<ansNum;j++)
            {
                List<Integer> temp_list = new ArrayList<>(ans.get(j));
                for(int k=0;k<=dupCount;k++)
                {
                    temp_list.add(nums[i]);
                    ans.add(new ArrayList<>(temp_list));
                }
            }
        }
        return ans;
    }
}
