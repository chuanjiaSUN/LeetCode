package Arrays.day20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]

 * @create 2021-03-26 13:04
 */
public class exercise442 {
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }else{
                answer.add(nums[i]);
            }
        }
        return answer;
    }

    //优化 原地哈希，不采用额外空间
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        int length = nums.length;
        for(int i=0;i<length;i++)
        {
            //以数组元素的值作为索引，去对对应的数组元素取反
            int index = Math.abs(nums[i]);
            if(nums[index - 1]<0)//小于零说明之前有元素对它取过反，因此那个元素出现了2次
            {
                answer.add(index);
            }else{
                nums[index - 1] *= -1;
            }
        }
        return answer;
    }
}
