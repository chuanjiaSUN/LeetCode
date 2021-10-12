package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-11 11:21
 */
public class Exe321 {
    /**单调栈*/
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;

        //数组实现单调栈
        int[] maxSubSequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);

        for (int i = start; i <= end; i++)
        {
            int[] subSequence1 = maxSubSequence(nums1, i);
            int[] subSequence2 = maxSubSequence(nums2, k - i);
            int[] curMaxSubSequence = merge(subSequence1, subSequence2);
            if (compare(curMaxSubSequence, 0, maxSubSequence, 0) > 0)
            {
                System.arraycopy(curMaxSubSequence, 0, maxSubSequence, 0, k);
            }
        }
        return maxSubSequence;
    }

    private int compare(int[] subSequence1, int idx1, int[] subSequence2, int idx2) {
        int x = subSequence1.length, y = subSequence2.length;
        while (idx1 < x && idx2 < y)
        {
            int diff =subSequence1[idx1] - subSequence2[idx2];
            if (diff != 0)
            {
                return diff;
            }
            idx1++;
            idx2++;
        }
        return (x - idx1) - (y - idx2);
    }

    private int[] merge(int[] subSequence1, int[] subSequence2) {
        int x = subSequence1.length, y = subSequence2.length;
        if (x == 0)
        {
            return subSequence2;
        }
        if (y == 0)
        {
            return subSequence1;
        }
        int mergeLen = x + y;
        int[] merged = new int[mergeLen];
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < mergeLen; i++)
        {
            if (compare(subSequence1, idx1, subSequence2, idx2) > 0)
            {
                merged[i] = subSequence1[idx1++];
            }else{
                merged[i] = subSequence2[idx2++];
            }
        }
        return merged;
    }

    private int[] maxSubSequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        //remain表示还可以删去多少字符
        int remain = length - k;
        for (int i = 0; i < length; i++)
        {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0)
            {
                top--;
                remain--;
            }
            if (top < k - 1)
            {
                stack[++top] = num;
            }else{
                //避免超过边界少删除字符
                remain--;
            }
        }
        return stack;
    }
}
