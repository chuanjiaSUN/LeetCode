package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-24 13:16
 */
public class Exe740 {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums)
        {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums)
        {
            sum[val] += val;
        }
        return rob(sum);
    }

    private int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++)
        {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
    /**动规*/
    public int deleteAndEarn1(int[] nums)
    {
        int max = 0;
        for (int val : nums)
        {
            max = Math.max(val, max);
        }
        int[] cnt = new int[max + 1];
        for (int val : nums)
        {
            cnt[val]++;
        }
        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++)
        {
            f[i][1] = f[i - 1][0] + i * cnt[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }

    /**空间优化*/
    public int deleteAndEarn2(int[] nums)
    {
        int max = 0;
        for (int val : nums)
        {
            max = Math.max(val, max);
        }
        int[] cnt = new int[max + 1];
        for (int val : nums)
        {
            cnt[val]++;
        }
        int choose = 0, noChoose = 0;
        for (int i = 1; i <= max; i++)
        {
            int temp = noChoose;
            int temp1 = choose;
            temp1 = noChoose + i * cnt[i];
            temp = Math.max(noChoose, choose);
            choose = temp1;
            noChoose = temp;
        }
        return Math.max(choose, noChoose);
    }

}
