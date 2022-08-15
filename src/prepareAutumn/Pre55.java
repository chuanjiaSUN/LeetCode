package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-17 21:12
 */
public class Pre55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++){
            max = Math.max(max, i + nums[i]);
            if (max >= len){
                return true;
            }
        }
        return false;
    }
    /**
     * practice
     * */
    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int end = 0;
        int max = 0;
        for (int i = 0; i < len; i++){
            if (i <= end){
                max = Math.max(max, i + nums[i]);
            }
            if (i == end){
                end = max;
            }
        }
        return max >= len - 1;
    }
}
