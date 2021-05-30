package Arrays.day02;

/**
 * @author sunchuanjia
 * @Description 152. 乘积最大子数组
 *
 * 标签：动态规划
 * //法1
 * 遍历数组时计算当前最大值，不断更新
 * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
 * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
 * 当负数出现时则imax与imin进行交换再进行下一步计算
 * 时间复杂度：O(n)O(n)
 *
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @create 2021-03-07 11:27
 */
public class exercise152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int iMax = 1, iMin = 1;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]<0){
                int temp;
                temp = iMin;
                iMin = iMax;
                iMax = temp;
            }

            iMax = Math.max(iMax*nums[i],nums[i]);
            iMin = Math.min(iMin*nums[i],nums[i]);

            max = Math.max(max,iMax);

        }
        return max;
    }

    //法2
    public int maxProduct1(int[] nums){
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums,0,maxF,0,length);
        System.arraycopy(nums,0,minF,0,length);
        for(int i=1;i<length;i++){
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(minF[i-1]*nums[i],nums[i]));
            minF[i] = Math.min(maxF[i-1]*nums[i],Math.min(maxF[i-1]*nums[i],nums[i]));
        }

        int result = maxF[0];
        for (int i=1;i<length;i++){
            result = Math.max(result,maxF[i]);
        }
        return result;
    }

    //法3 法2的优化，用2个临时变量维护MaxF,MinF
    //记 nums 元素个数为 nn。
    //
    //时间复杂度：程序一次循环遍历了 nums，故渐进时间复杂度为 O(n)O(n)。
    //
    //空间复杂度：优化后只使用常数个临时变量作为辅助空间，与 nn 无关，故渐进空间复杂度为 O(1)O(1)。

    public int maxProduct2(int[] nums){
        int length = nums.length;
        int iMax = nums[0];
        int iMin = nums[0];
        int max = nums[0];
        for(int i=1;i<length;i++){//用2个变量维护mx,mn i-1时刻的最值
            int mx = iMax,mn = iMin;
            iMax = Math.max(mx*nums[i],Math.max(mn*nums[i],nums[i]));
            iMin = Math.min(mn*nums[i],Math.min(mx*nums[i],nums[i]));
            max = Math.max(iMax,max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2};
        exercise152 e = new exercise152();
        System.out.println(e.maxProduct(nums));
        System.out.println(e.maxProduct1(nums));
        System.out.println(e.maxProduct2(nums));
    }
}
