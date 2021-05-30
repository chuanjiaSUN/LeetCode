package Arrays.day16;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true

 * @create 2021-03-22 20:40
 */
public class exercise217 {
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<length;i++)
        {
            set.add(nums[i]);
        }
        return set.size()==length?false:true;
    }
    public boolean containsDuplicate1(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num:nums)
        {
            if(!set.contains(num))
            {
                set.add(num);
            }else{
                return true;
            }
        }
        return false;
    }

}
