package Arrays.day26;

/**
 * @author sunchuanjia
 * @Description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

 * 输入：nums = [1]
 * 输出：1

 * 输入：nums = [0]
 * 输出：0

 * 输入：nums = [-1]
 * 输出：-1

 * 输入：nums = [-100000]
 * 输出：-100000
 * @create 2021-04-01 11:09
 */
public class exercise53 {
    //动规
    public int maxSubArray(int[] nums)
    {
        int length = nums.length;
        if( length == 1) return nums[0];
        int max = 0;
        int[] f = new int[length];
        f[0] = nums[0];
        for(int i = 1; i < length; i++)
        {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
            if(f[i] > max)
            {
                max = f[i];
            }
        }
        return max;
    }
    //分治

    class Status{
        private int lSum,rSum,iSum,mSum;
        public Status(int lSum,int rSum,int iSum, int mSum)
        {
            this.iSum = iSum;
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
        }

    }
    public int maxSubArray1(int[] nums)
    {
        return getInfo(nums,0,nums.length-1).mSum;
    }

    private Status getInfo(int[] nums, int l, int r) {
        if( l == r)return new Status(nums[l],nums[l],nums[l],nums[l]);
        int m = l + (r-l)/2;
        Status lSub = getInfo(nums,l,m);
        Status rSub = getInfo(nums,m+1,r);
        return pushUp(lSub,rSub);
    }

    private Status pushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum, lSub.iSum + rSub.lSum);
        int rSum = Math.max(rSub.rSum, rSub.iSum + lSub.rSum);
        int mSum = Math.max(Math.max(rSub.mSum,lSub.mSum), lSub.rSum + rSub.lSum);
        return new Status(lSum, rSum, iSum, mSum);
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        exercise53 e = new exercise53();
        int i = e.maxSubArray1(nums);
        System.out.println(i);
    }
}
