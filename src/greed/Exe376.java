package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-11 11:47
 */
public class Exe376 {
    /**贪心*/
    public int wiggleMaxLength(int[] nums) {
        if (nums == null)
        {
            return 0;
        }
        int n = nums.length;
        if (n < 2)
        {
            return n;
        }
        int prevDiff = nums[1] - nums[0];
        int ret = prevDiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++)
        {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0))
            {
                ret++;
                prevDiff = diff;
            }
        }
        return ret;
    }
    /**DP*/
    public int wiggleMaxLength2(int[] nums)
    {
        int n = nums.length;
        if (n < 2)
        {
            return n;
        }
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = down[0] = 1;
        for (int i = 1; i < n; i++)
        {
            if (nums[i] > nums[i - 1])
            {
                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                down[i] = down[i - 1];
            }else if (nums[i] < nums[i - 1])
            {
                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
                up[i] = up[i - 1];
            }else{
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[n - 1], down[n - 1]);
    }
}
