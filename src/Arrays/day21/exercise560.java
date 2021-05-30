package Arrays.day21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

 * @create 2021-03-27 10:46
 */
public class exercise560 {
    //枚举，复杂度O(n^2)
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for(int i=0;i<length;i++)
        {
            int sum = 0;
            for(int j=0;j>=0;j--)
            {
                sum += nums[j];
                if(sum == k)
                {
                    count++;
                }
            }
        }
        return count;
    }
    //前缀和 + 哈希表 优化
    public int subarraySum1(int[] nums, int k){
        int count = 0,pre=0;//pre记录前一个前缀和
        Map<Integer,Integer>  map = new HashMap<>();
        map.put(0,1);//map记录前N项和及次数
        for(int i=0;i<nums.length;i++)
        {
            pre += nums[i];
            if(map.containsKey(pre-k))
            {
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    //again
    public int subarraySum2(int[] nums, int k){
        int count =0,pre = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            pre += nums[i];//前面i项的和
            if(map.containsKey(pre-k))
            {
                count += map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
