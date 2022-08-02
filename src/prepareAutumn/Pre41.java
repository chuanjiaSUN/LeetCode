package prepareAutumn;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-02 23:06
 */
public class Pre41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            if(num <= n){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Pre41 pre = new Pre41();
        int i = pre.firstMissingPositive(new int[]{3, 4, -1, 1});
        System.out.println(i
        );
    }
}
