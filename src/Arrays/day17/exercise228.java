package Arrays.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 示例 1：
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"

 * @create 2021-03-23 9:40
 */
public class exercise228 {
    public List<String> summaryRanges(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int i=0;
       while(i<nums.length)
        {
            res.clear();
            res.add(nums[i]);
            int j=i+1;
            while (j<nums.length && nums[j]==nums[j-1]+1)
            {
                res.add(nums[j]);
                j++;
            }
            String start = String.valueOf(res.get(0));
            String end=null;
            if(res.size()>1){
                end = Integer.toString(res.get(res.size()-1));
                ans.add(start+"-->"+end);
            }else{
                ans.add(start);
            }
            i = j;
        }
        return ans;

    }
    //法2 用一个列表
    public List<String> summaryRanges1(int[] nums){
        List<String> res = new ArrayList<>();
        int i=0,length = nums.length;
        while(i<length)
        {
            int low = i;
            i++;
            while(i<length && nums[i]==nums[i-1]+1)
            {
                i++;
            }
            int high = i - 1;
            StringBuffer sb = new StringBuffer(Integer.toString(nums[low]));
            if(low<high)
            {
                sb.append("->");
                sb.append(Integer.toString(nums[high]));
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        exercise228 e = new exercise228();
        int[] nums = {0,1,2,4,5,7};
        List<String> strings = e.summaryRanges(nums);
        System.out.println(strings);

    }
}
