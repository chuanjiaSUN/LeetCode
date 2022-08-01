package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-30 18:48
 */
public class Pre27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pre = -1;
        int cur = 0;
        while (cur < len){
            if (nums[cur] != val){
                nums[pre + 1] = nums[cur];
                pre += 1;
            }
            cur++;
        }
        return pre == -1 ? 0 : pre + 1;
    }
}
