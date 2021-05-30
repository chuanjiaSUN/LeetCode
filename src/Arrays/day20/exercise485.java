package Arrays.day20;

/**
 * @author sunchuanjia
 * @Description 给定一个二进制数组， 计算其中最大连续 1 的个数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.

 * @create 2021-03-26 16:06
 */
public class exercise485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int p1,answer = Integer.MIN_VALUE;
        int length = nums.length;
        for(int p0=0;p0<length;p0++)
        {
            int count =0;
            p1 = p0;
            while(p1<length && nums[p1]==1)
            {
                count++;
                p1++;
            }
            answer = Math.max(answer,count);
            p0 = p1;
        }
        return answer;
    }
}
