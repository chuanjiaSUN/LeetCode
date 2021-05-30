package Arrays.day26;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6

 * @create 2021-04-01 10:47
 */
public class exercise697 {
    //哈希表
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();// int数组记录 次数。首次位置。最后位置
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            }else{
                map.put(nums[i],new int[]{1,i,i});
            }
        }
        int maxNum = 0, minLen = 0;
        for(Map.Entry<Integer, int[]> entry:map.entrySet())
        {
            int[] arr = entry.getValue();
            if(maxNum < arr[0])
            {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            }else if(maxNum == arr[0])
            {
                if(minLen > arr[2] - arr[1] + 1)
                {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

    //哈希表一次遍历
    public int findShortestSubArray1(int[] nums)
    {
        int minLen = 0,maxCount = 0,length = nums.length;
        Map<Integer, int[]> map = new HashMap<>();// int[] 记录出现次数与第一次出现位置
        for( int i = 0; i < length; i++)
        {
            int[] pos = map.get(nums[i]);
            if(pos == null)
            {
                pos = new int[]{1,i};
                map.put(nums[i],pos);
            }else{
                pos[0]++;
            }
            if(pos[0] > maxCount)
            {
                maxCount = pos[0];
                minLen = i - pos[1] + 1;
            }else if(maxCount == pos[0])
            {
                minLen = Math.min(minLen,  i - pos[1] + 1);
            }
        }
        return minLen;
    }


}
