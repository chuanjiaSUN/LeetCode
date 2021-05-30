package Arrays.day25;

/**
 * @author sunchuanjia
 * @Description 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
 * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
 * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。

 * 输入: [1,2,1,2,6,7,5,1], 2
 * 输出: [0, 3, 5]
 * 解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
 * 我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。

 * @create 2021-03-31 12:12
 */

/*
* cache[i] = sum( nums[i],nums[i+1],...nums[i+k])
* int max_idx(int[] arr, int i, int j) -> 数组arr在[i,j]范围内的最大值的第一次出现的位置
* left[i] = max_idx( cache, 0, i)
* right[i] = max_idx( cache, i, cache.length - 1)
* */
public class exercise689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int[] cache = new int[nums.length - k + 1];
        int[] left = new int[nums.length - k + 1];
        int[] right = new int[nums.length - k + 1];
        int sum = 0;
        for(int i = 0 ; i < k; i++)
        {
            sum += nums[i];
        }
        cache[0] = sum;
        //统计每个位置k项后缀和，并计算从左往右遍历到当前位置的最大值出现的位置
        for(int i = 1; i < cache.length; i++)
        {
            int v = cache[i] = sum = sum + nums[ i + k - 1] - nums[ i - 1];
            if( v > cache[left[ i - 1]])
            {
                left[i] = i;
            }else{
                left[i] = left[ i - 1];
            }
        }

        //从后往前遍历，计算从后往前出现最大值的第一个位置
        right[right.length - 1] = right.length - 1;
        for(int j = cache.length - 2; j>=0; j--)
        {
            if(cache[j] >= cache[right[j+1]])
            {
                right[j] = j;
            }else{
                right[j] = right[j+1];
            }
        }

        int interval = k<<1;
        int[] res = new int[]{0, k, interval};
        int max = Integer.MIN_VALUE;
        for( int m = k; m < cache.length - k; m++)
        {
            int v = cache[left[m-k]] + cache[m] + cache[right[m+k]];//不重叠的区间
            if(v > max)
            {
                max = v;
                res[0] = left[m-k];
                res[1] = m;
                res[2] = right[m+k];
            }
        }
        return res;
    }
}
