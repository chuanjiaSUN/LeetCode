package Arrays.day06;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-11 14:22
 */
public class exercise53 {
    //法1 动态规划
    //转移方程 f(i) = max(f(i-1)+nums[i],nums[i]); f(i)即为当前位置的最大连续和
    public int maxSubArray(int[] nums) {
        int max ;
        int length = nums.length;
        if(length == 1)
        {
            return  nums[0];
        }
        int[] f = new int[length];
        f[0] = nums[0];
        max = f[0];
        for(int i = 1;i<length;i++)
        {
            f[i] = Math.max(f[i-1]+nums[i],nums[i]);
            if(f[i] > max)
            {
                max = f[i];
            }
        }
        return max;
    }

    //法2 分治算法
    public class Status{
        private int lSum,rSum,mSum,iSum;

        public Status(int lSum,int rSum, int mSum,int iSum)
        {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = mSum;
        }
    }

    public int maxSubArray1(int[] nums){
        return getDistance(nums,0,nums.length-1).mSum;
    }

    public Status getDistance(int[] nums,int left,int right){
        if(left == right)
        {
            return new Status(nums[left],nums[left],nums[left],nums[left]);
        }
        //分治
        int mid = (left + right)/2;
        Status lSub = getDistance(nums, left, mid);
        Status rSub = getDistance(nums, mid + 1, right);
        return PushUp(lSub,rSub);
    }

    //将分治完返回的左右两边信息聚合
    private Status PushUp(Status lSub, Status rSub) {
        int iSum = lSub.iSum + rSub.iSum;
        int lSum = Math.max(lSub.lSum,lSub.iSum+rSub.lSum);
        int rSum = Math.max(rSub.rSum,rSub.iSum+lSub.rSum);
        int mSum = Math.max(Math.max(lSub.mSum,rSub.mSum),lSub.rSum+rSub.lSum);
        return new Status(lSum,rSum,mSum,iSum);
    }

    public static void main(String[] args) {
        exercise53 exercise53 = new exercise53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = exercise53.maxSubArray(nums);
        int i = exercise53.maxSubArray1(nums);
        System.out.println(max);
        System.out.println(i);
    }
}
