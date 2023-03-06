package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-27 22:37
 */
public class Pre152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        System.arraycopy(nums, 0, max, 0, len);
        System.arraycopy(nums, 0, min, 0, len);
        for (int i = 1; i < len; i++){
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(nums[i], max[i - 1] * nums[i]));
        }
        int ans = max[0];
        for (int i = 1; i < len; i++){
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
    /**
     * practice
     * */
    public int maxProduct1(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        System.arraycopy(nums, 0, max, 0, len);
        System.arraycopy(nums, 0, min, 0, len);
        for (int i = 1; i < len; i++){
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(min[i - 1] * nums[i], Math.min(nums[i], max[i - 1] * nums[i]));
        }
        int ans = max[0];
        for (int i = 1; i < len; i++){
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }
}
