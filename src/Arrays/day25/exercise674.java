package Arrays.day25;

/**
 * @author sunchuanjia
 * @Description 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * @create 2021-03-31 11:32
 */
public class exercise674 {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if( length == 0) return 0;
        int maxLength = 1;
        int left,right;
        for(left = 0; left < length; left++)
        {
            right = left;
            while(right < length-1 && nums[right] < nums[right + 1])
            {
                right++;
                maxLength = Math.max(maxLength, right - left + 1);

            }
        }
        return maxLength;
    }

    //法2 贪心
    public int findLengthOfLCIS1(int[] nums)
    {
        int length = nums.length;
        if( length == 0) return  0;
        int ans = 0;
        int start = 0;
        for(int i = 0; i < length; i++)
        {
            if( i > 0 && nums[i] <= nums[i - 1])
            {
                start = i;
            }
            ans = Math.max(i - start + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2,2};
        exercise674 e = new exercise674();
        int lengthOfLCIS = e.findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }
}
