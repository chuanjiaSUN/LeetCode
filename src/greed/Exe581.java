package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-15 11:09
 */
public class Exe581 {
    public int findUnsortedSubarray(int[] nums) {
        if(isSorted(nums))
        {
            return 0;
        }
        int len = nums.length;
        int[] numsSorted = new int[len];
        System.arraycopy(nums, 0, numsSorted, 0, len);
        Arrays.sort(numsSorted);
        int left = 0;
        while (nums[left] == numsSorted[left])
        {
            left++;
        }
        int right = len - 1;
        while (nums[right] == numsSorted[right])
        {
            right--;
        }
        return right - left + 1;
    }

    private boolean isSorted(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                return false;
            }
        }
        return true;
    }


    /**1次遍历*/
    public int findUnsortedSubarray1(int[] nums)
    {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++)
        {
            if (maxn > nums[i])
            {
                right = i;
            }else{
                //小于max说明存在逆序
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1])
            {
                left = n - i - 1;
            }else{
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }

}
