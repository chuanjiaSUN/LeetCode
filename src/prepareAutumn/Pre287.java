package prepareAutumn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-04 22:46
 */
public class Pre287 {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    public int findDuplicate1(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        int ans = -1;
        while (left <= right){
            int mid = (left + right) >> 1;
            int cnt = 0;
            for (int i = 0; i < len; i++){
                if (nums[i] <= mid){
                    cnt++;
                }
            }
            if (cnt <= mid){
                left = mid + 1;
            }else{
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
