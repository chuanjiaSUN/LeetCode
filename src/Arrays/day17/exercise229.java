package Arrays.day17;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]

 * @create 2021-03-23 10:19
 */
public class exercise229 {
    public List<Integer> majorityElement(int[] nums) {
        int length = nums.length;
        if(length==0)return new ArrayList<>();
        int count = nums.length/3;
        Map<Integer,Integer>  map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for(Map.Entry<Integer,Integer> entry:entries)
        {
            if(entry.getValue()>count) ans.add(entry.getKey());
        }
        return ans;
    }
    //法2 摩尔投票法
    public List<Integer> majorityElement1(int[] nums){
        int length = nums.length;
        if(length==0||nums==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int candidate1 = nums[0],count1 = 0;
        int candidate2 = nums[0],count2 = 0;

        for(int num:nums)
        {
            //投票
            if(candidate1==num)
            {
                count1++;
                continue;
            }
            if(candidate2==num)
            {
                count2++;
                continue;
            }
            //候选人匹配
            if(count1 ==0)
            {
                candidate1 = num;
                count1++;
                continue;
            }
            if(count2 == 0)
            {
                candidate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        //计数
        count1 = 0;
        count2 = 0;
        for(int num:nums)
        {
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }
        if(count1 > length/3) ans.add(candidate1);
        if(count2 > length/3) ans.add(candidate2);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        exercise229 e = new exercise229();
        List<Integer> list = e.majorityElement(nums);
        System.out.println(list);
    }
}
