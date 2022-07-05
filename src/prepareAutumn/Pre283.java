package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-04 22:36
 */
public class Pre283 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int cur = 0;
        int last = 0;
        while (cur < len){
            if (nums[cur] != 0){
                nums[last++] = nums[cur];
            }
            cur++;
        }
        while (last < len){
            nums[last++] = 0;
        }
    }
}
