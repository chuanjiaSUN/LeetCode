package num100;

import org.junit.Test;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-21 16:11
 */
public class Exe75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int ptr = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i < len; i++){
            if (nums[i] == 1){
                int temp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = temp;
                ptr++;
            }
        }
    }

    //双指针
    public void sortColors1(int[] nums) {
        int len = nums.length;
        int p0 = 0, p2 = len - 1;
        for (int i = 0; i < len; i++){
            while (i <= p2 && nums[i] == 2){
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2--;
            }
            if (nums[i] == 0){
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }
    }

    @Test
    public void test(){
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("1");
            }
        };
        thread.start();
    }
}
