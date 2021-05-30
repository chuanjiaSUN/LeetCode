package Arrays.day21;

/**
 * @author sunchuanjia
 * @Description 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 *
 * @create 2021-03-27 11:19
 */
public class exercise713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        if(length==0) return 0;
        int count = 0;
        int p1;
        for(int p0=0;p0<length;p0++)
        {
            int res = nums[p0];
            if(res>=k) continue;
            count++;
            p1 = p0 +1;
            while(p1<length && res*nums[p1]<k)
            {
                count++;
                res = res * nums[p1];
                p1++;
            }
        }
        return count;
    }
    //双指针
    public int numSubarrayProductLessThanK1(int[] nums, int k){
        if(k<=1)return 0;
        int prod = 1,count = 0,left = 0;
        for(int right = 0;right<nums.length;right++)
        {
            prod *= nums[right];
            while(prod>=k) prod /= nums[left++];
            count += (right - left + 1);
        }
        return count;
    }
    //先存取前缀和，再二分查找
    public int numSubarrayProductLessThanK2(int[] nums, int k){
        if(k==0) return 0;
        //为了防止算术溢出，取对数
        double logk = Math.log(k);
        double[] prefix = new double[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            prefix[i+1] = prefix[i] + Math.log(nums[i]);
        }
        int count = 0;
        for(int i=0;i<prefix.length;i++)
        {
            int low = i+1, high = prefix.length;
            while(low<high)
            {
                int mid =low + (high-low)/2;
                if(prefix[mid] < prefix[i] + logk - 1e-9){
                    low = mid + 1;
                }else{
                    high = mid;
                }
            }
            count += low - i -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        exercise713 e = new exercise713();
        int i = e.numSubarrayProductLessThanK2(nums, 100);
        System.out.println(i);
    }
}
