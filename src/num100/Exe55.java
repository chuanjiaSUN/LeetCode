package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-20 16:53
 */
public class Exe55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxJump = 0;
        for (int i = 0; i < len; i++){
            if (i <= maxJump){
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= len - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
