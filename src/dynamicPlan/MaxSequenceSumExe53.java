package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-01 13:11
 */
public class MaxSequenceSumExe53 {
    /**动态规划*/
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums)
        {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
    /**分治*/
    public class Status{
        int lSum,rSum,mSum,iSum;
        public Status(int lSum,int rSum, int mSum, int iSum)
        {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }
    public int maxSubArray1(int[] nums)
    {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] nums, int left, int right) {
        if (left == right)
        {
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        }
        int m = (left + right) >> 1;
        Status lSub = getInfo(nums, left, m);
        Status rSub = getInfo(nums, m + 1, right);
        return pushUp(lSub, rSub);
    }

    private Status pushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rSum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
        int mSum = Math.max(Math.max(lSub.mSum, rSub.mSum), lSub.rSum + rSub.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
