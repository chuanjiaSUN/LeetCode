package Arrays.day15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *  
 *
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9

 * @create 2021-03-21 19:43
 */
public class BingChaJi_exercise128 {
    //采用哈希表存储，遍历哈希表
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int num:nums)
        {
            num_set.add(num);
        }
        int answer = 0;
        for(int num:num_set)
        {
            if(!num_set.contains(num-1))
            {
                int currentNum = num;
                int currentCount = 1;
                while(num_set.contains(currentNum+1))
                {
                    currentNum++;
                    currentCount++;
                }
                answer = Math.max(answer,currentCount);
            }
        }
        return answer;
    }

    //againTest
    public int longestConsecutive1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        int answer = 0;
        for(int num:set)
        {
            if(!set.contains(num-1)){
                int currentCount = 1;
                int currentNum = num;
                while(set.contains(currentNum+1))
                {
                    currentCount++;
                    currentNum++;
                }
                answer = Math.max(answer,currentCount);
            }
            
        }
        return answer;
    }

    //动态规划 + 哈希表
    public int longestConsecutive22(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int length = 0;
        for(int num:nums)
        {
            int cur = 0;
            int left=0,right=0;
            if(!map.containsKey(num))
            {
                //取左右端点的区间长度
                left = map.containsKey(num-1)?map.get(num-1):0;
                right = map.containsKey(num+1)?map.get(num+1):0;
                cur = right + left + 1;
            }
            length = Math.max(length,cur);//更新最值
            //更新当前端点的值
            map.put(num,cur);
            map.put(num-left,cur);
            map.put(num+right,cur);
        }
        return length;
    }
}
