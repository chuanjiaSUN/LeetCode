package Arrays.day22;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 *
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

 * @create 2021-03-28 10:40
 */
public class exercise565 {
    //法1
    public int arrayNesting(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int maxLength = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<length;i++)
        {
            set.clear();
            int index = nums[i];
            set.add(nums[i]);
            while(!set.contains(nums[index])){
                set.add(nums[index]);
                index = nums[index];
            }
            maxLength = Math.max(maxLength,set.size());
        }
        return maxLength;
    }

    //法2 使用访问过的数组记录信息,法1中Nums数组所有元素都被添加到对应于所有起始索引的集合，有冗余,有重复的集合
    public int arrayNesting1(int[] nums)
    {
        int length = nums.length;
        if(length == 0) return 0;
        boolean[] visited = new boolean[length];
        int maxLength = 0;
        for(int i=0;i<length;i++)
        {
            if(!visited[i])
            {
                int index = nums[i];
                int count = 0;
                do{
                    index = nums[index];
                    count++;
                    visited[i] = true;
                }while (index != nums[i]);
                maxLength = Math.max(maxLength,count);
            }
        }
        return maxLength;
    }

    //法3 不使用额外空间
    public int arrayNesting2(int[] nums){
        int length = nums.length;
        if(length == 0) return 0;
        int maxLength = 0;
       for(int i = 0; i < length; i++)
       {
           if(nums[i] != Integer.MAX_VALUE)
           {
               int index = nums[i],count = 0;
               while (nums[index] != Integer.MAX_VALUE)
              {
                  int temp = index;
                  index = nums[index];
                  count ++;
                  nums[temp] = Integer.MAX_VALUE;//标记访问过的元素
              }
              maxLength = Math.max(maxLength,count);
           }
       }
       return maxLength;
    }
}
