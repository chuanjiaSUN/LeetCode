package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-30 18:30
 */
public class Pre26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int pre = 1;
        int cur = 1;
        while (cur < len){
            if (nums[cur] != nums[cur - 1]){
                nums[pre] = nums[cur];
                pre++;
            }
            cur++;
        }
        return pre;
    }
}
