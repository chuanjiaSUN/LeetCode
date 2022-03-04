package num100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-28 12:07
 */
public class ByteTest {

    public int MinWeight(int[] nums, String str, int k){
        int len = nums.length;
        char[] arr = str.toCharArray();
        int ans = 0;
        for(int i = 0; i < k; i++){
            if (arr[i] == 'R') continue;
            else{
                ans += nums[i];
            }
        }

        /**K大小窗口滑动*/
        for (int i = 1; i < len - k; i++){
            int temp = ans;
            if (arr[i - 1] == 'W'){
                ans -= nums[i - 1];
            }
            if (arr[i + k - 1] == 'W'){
                ans += nums[i + k - 1];
            }
            ans = Math.min(temp, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        ByteTest test = new ByteTest();
        int[] nums = new int[]{1, 2, 3, 4, 5, 10, 8, 9};
        String str = "WWRRWWRR";
        long l = System.currentTimeMillis();
        int i = test.MinWeight(nums, str, 3);
        System.out.println(i);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
