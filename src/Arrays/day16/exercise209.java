package Arrays.day16;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0

 * @create 2021-03-22 17:19
 */
public class exercise209 {
    //暴力法
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if(length==0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<length;i++)
        {
            int sum = 0;
            for(int j=i;j<length;j++)
            {
                sum += nums[j];
                if(sum >= target)
                {
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        return ans==Integer.MAX_VALUE? 0:ans;
    }
    //法2 2分法
    public int minSubArrayLen1(int target, int[] nums){
        int length = nums.length;
        if(length==0) return 0;
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[length+1];//令sum[0]=0
        sum[0] = 0;
        for(int i=1;i<=length;i++)
        {
            sum[i] = sum[i-1] + nums[i-1];
        }
        for(int i=1;i<=length;i++)
        {
            int s = target + sum[i - 1];
            int bound = BinarySearch(sum,s);
            if(bound < 0)
            {
                bound = -bound - 1;
            }
            if(bound <= length)
            {
                ans = Math.min(ans, bound-(i-1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    private int BinarySearch(int[] sum, int target) {
        int left = 0;
        int right = sum.length - 1;
        int mid ;
        while(left <= right)//这里left + 1后 sum的值可能一下增大很多，所以必须要再进去比较一次。
        {
            mid = left + ( right - left) / 2;
            if (sum[mid]==target) return mid;
            if(sum[mid] > target)
            {
                right = mid - 1;
            }else if(sum[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
    //法3 滑动窗口
    public int minSubArrayLen2(int target, int[] nums)
    {
        int length = nums.length;
        if(length==0) return 0;
        int start = 0,end = 0;
        int answer = Integer.MAX_VALUE ,sum = 0;
        while(end<length)
        {
            sum += nums[end];
            while(sum>=target)
            {
                answer = Math.min(answer,end-start+1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return answer==Integer.MAX_VALUE?0:answer;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        exercise209 e = new exercise209();
        int i = e.minSubArrayLen1(7, nums);
        System.out.println(i);
    }

}
