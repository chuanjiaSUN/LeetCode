package Arrays.day21;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description 给定一个整数数组和一个整数 k，你需要在数组里找到不同的 k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *这里将 k-diff 数对定义为一个整数对 (nums[i], nums[j])，并满足下述全部条件：

 * 0 <= i, j < nums.length
 * i != j
 * |nums[i] - nums[j]| == k
 * 注意，|val| 表示 val 的绝对值。

 * 示例 1：
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。

 * @create 2021-03-27 10:16
 */
public class exercise532 {
    //集合
    public int findPairs(int[] nums, int k) {
        int length = nums.length;
        if(length==0||nums==null) return 0;
        Set<Integer> saw = new HashSet<>();
        Set<Integer> diff = new HashSet<>();
        for(int num:nums)
        {
            if(saw.contains(num + k))
            {
                diff.add(num);
            }
            if(saw.contains(num - k))
            {
                diff.add(num-k);
            }
            saw.add(num);
        }
        return diff.size();
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        exercise532 e = new exercise532();
        int pairs = e.findPairs(nums, 2);
        System.out.println(pairs);
    }
}
