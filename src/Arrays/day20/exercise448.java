package Arrays.day20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 * @create 2021-03-26 13:58
 */
public class exercise448 {
    //使用额外空间
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int num:nums)
        {
            answer.add(num);
        }
        for(int i=1;i<=nums.length;i++)
        {
            if(!answer.contains(i))
            {
                res.add(i);
            }
        }
        return res;
    }

    //原地哈希 不使用额外空间
    public List<Integer> findDisappearedNumbers1(int[] nums){
        int length =nums.length;
        List<Integer> answer = new ArrayList<>();
        for(int num:nums)
        {
            int x = (num - 1) % length;
            nums[x] += length;//使出现了的值对应索引的值 +n
        }
        for(int i=0;i<length;i++)
        {
            if(nums[i]<=length)
            {
                answer.add(i+1);
            }
        }
        return answer;
    }

}
