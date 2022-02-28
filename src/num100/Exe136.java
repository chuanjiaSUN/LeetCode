package num100;


/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-27 11:56
 */
public class Exe136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
