package Arrays.day24;

/**
 * @author sunchuanjia
 * @Description 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

 * @create 2021-03-30 9:39
 */
public class exercise643 {
    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        if(length < k) return 0;
        double maxMean = Integer.MIN_VALUE;
        for(int i = 0; i < length - k; i++)
        {
            int sum = 0;
            for(int j=i; j<i+k; j++)
            {
                sum += nums[j];
            }
            maxMean = Math.max(sum, maxMean);
        }
        return 1.0 * maxMean /k;
    }
    //滑动窗口
    public double findMaxAverage1(int[] nums, int k)
    {
        int length = nums.length;
        if(length < k) return 0;
        int sum = 0;
        for(int i=0;i<k;i++)
        {
            sum += nums[i];
        }
        int maxSum = sum;
        for(int i = k;i<length;i++)
        {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(sum,maxSum);
        }
        return 1.0*maxSum/k;
    }

    public static void main(String[] args) {
        exercise643 e = new exercise643();
        int[] nums = {1,12,-5,-6,50,3};
        double maxAverage = e.findMaxAverage1(nums, 4);
        System.out.println(maxAverage);
    }
}
