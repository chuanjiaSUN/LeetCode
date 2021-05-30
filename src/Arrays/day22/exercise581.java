package Arrays.day22;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。

 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

 * 输入：nums = [1,2,3,4]
 * 输出：0

 * 输入：nums = [1]
 * 输出：0
 * @create 2021-03-28 11:47
 */
public class exercise581 {
    // 错误方法
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if( length == 0 ) return 0;
        int left = 0, right = length - 1;
        while(left < length - 1 && nums[left]<=nums[left + 1])
        {
            left++;
        }
        while(right>0 && nums[right] >= nums[right - 1])
        {
            right--;
        }
        return right>left?right-left+1:0;
    }
    //法1 找到满足左边数字比右边数字大的边界 left 与 right
    public int findUnsortedSubarray1(int[] nums)
    {
        int length = nums.length;
        int left = length, right = 0;
        for(int i = 0; i < length-1; i++)
        {
            for(int j = i + 1; j < length; j++)
            {
                if(nums[i] < nums[j])
                {
                    right = Math.max(j, right);
                    left = Math.min(i, left);
                }
            }
        }
        return right - left < 0? 0: right - left + 1;
    }
    //法2 排序,比较不匹配的元素  排序O(NlogN)
    public int findUnsortedSubarray2(int[] nums)
    {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int start = arr.length;
        int end = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == nums[i])
            {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return ( end - start ) > 0? end - start + 1: 0;
    }

    //法3 使用栈  思想： 选择排序
    public int findUnsortedSubarray3(int[] nums)
    {
        int length = nums.length;
        if(length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int right = 0, left = length;
        //做升序栈
        for(int i = 0; i < length; i++)
        {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
            {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        //做降序栈，找右边界
        for(int i = length - 1; i>=0; i--)
        {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
            {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }

    //法4 不使用额外空间 --->>> 思想是无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
    public int findUnsortedSubarray4(int[] nums)
    {
        int length = nums.length;
        if(length == 0) return 0;
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;
        boolean flag = false;
        //找无序子数组中第一个最小的值,
        for(int i = 1; i < length; i++)
        {
            //找到无序子数组的开头了
            if(nums[i] < nums[i-1])
            {
                flag = true;
            }
            if(flag)
            {
                leftMin = Math.min(nums[i], leftMin);
            }
        }
        flag = false;
        //找无序子数组中最大值,
        for(int i = length - 2; i >= 0; i--)
        {
            if( nums[i] > nums[i+1])
            {
                flag = true;
            }
            if(flag)
            {
                rightMax = Math.max(rightMax, nums[i]);
            }
        }
        //找无序数组的左右边界
        int left,right;
        for(left = 0; left < length; left++)//这里隐含了条件，leftMin左边的值一定都比它小
        {
            if(leftMin < nums[left])
            {
                break;
            }
        }
        for(right = length - 1; right >= 0; right--)//rightMax右边的值一定都比它大
        {
            if(rightMax > nums[right])
            {
                break;
            }
        }
        return right - left > 0? right - left + 1 : 0;
    }
    public static void main(String[] args) {
        exercise581 e = new exercise581();
        int unsortedSubarray = e.findUnsortedSubarray(new int[]{1});
        System.out.println(unsortedSubarray);
    }
}
