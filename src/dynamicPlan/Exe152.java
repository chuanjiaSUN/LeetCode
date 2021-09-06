package dynamicPlan;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-06 10:02
 */
public class Exe152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxF = new int[n];
        int[] minF = new int[n];
        System.arraycopy(nums, 0, maxF, 0,n);
        System.arraycopy(nums, 0, minF, 0,n);
        for(int i = 1; i < n; i++)
        {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int x : maxF)
        {
            ans = Math.max(ans, x);
        }
        return ans;
    }
    /**优化空间*/
    public int maxProduct1(int[] nums)
    {
        int n = nums.length;
        int maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        for (int i = 0; i < n; i++)
        {
            int mx = maxF;
            int mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx* nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
