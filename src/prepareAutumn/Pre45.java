package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-04 23:05
 */
public class Pre45 {
    public int jump(int[] nums) {
        int max = 0;
        int ans = 0;
        int end = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, i + nums[i]);
            if (i == end){
                ans++;
                end = max;
            }
        }
        return ans;
    }
}
