package Arrays.day15;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2

 * @create 2021-03-21 20:32
 */
public class exercise169 {

    //法1 排序
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int count =length/2;
        for(int i=0;i<length;i++)
        {
            if(nums[i]==nums[i+count])
            {
                return nums[i];
            }
        }
        return 0;
    }

    //法2 哈希表
    public int majorityElement1(int[] nums){
        Map<Integer, Integer> countMap = getMap(nums);
        Map.Entry<Integer,Integer> majorNum = null;
        Set<Map.Entry<Integer, Integer>> entries = countMap.entrySet();
        for(Map.Entry<Integer,Integer> entry:entries)
        {
            if(majorNum==null||entry.getValue()>majorNum.getValue())
            {
                majorNum = entry;
            }
        }
        return majorNum.getKey();
    }
    public Map<Integer,Integer> getMap(int[] nums)
    {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int num:nums)
        {
            if(!countMap.containsKey(num))
            {
                countMap.put(num,1);
            }else{
                countMap.put(num,countMap.get(num)+1);
            }
        }
        return countMap;
    }

    //法3 分治
    public int majorityElement2(int[] nums){
        return majorityElementRec(nums,0,nums.length-1);
    }

    private int majorityElementRec(int[] nums, int left, int right) {
        if(left==right){
            return nums[left];
        }

        int mid = (left + right)/2;
        int low = majorityElementRec(nums,left,mid);
        int high = majorityElementRec(nums,mid+1,right);

        if(low==high)
        {
            return low;
        }

        int leftCount = countInRange(nums,low,left,right);
        int rightCount = countInRange(nums,high,left,right);

        return leftCount>rightCount ? low:high;
    }

    private int countInRange(int[] nums, int num, int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++)
        {
            if(nums[i] == num)
            {
                count++;
            }
        }
        return count;
    }

    //Boyer-Moore投票
    public int majorityElement3(int[] nums){
        int candidate = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                candidate = nums[i];
            }
            if(candidate==nums[i]){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        exercise169 e = new exercise169();
        int[] nums = {3,2,3};
        int i = e.majorityElement(nums);
        System.out.println(i);
    }
}
