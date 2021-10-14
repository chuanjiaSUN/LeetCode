package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-29 10:30
 */
public class InterviewTest {
    public int search(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        int len = nums.length;
        int low = 0, high = len - 1;
        int mid = 0;
        while (low < high)
        {
            mid = low + ((high - low) >> 1);
            if (nums[mid] < target)
            {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7,8,10};
        InterviewTest test = new InterviewTest();
        int search = test.search(nums, 3);
        System.out.println(search);
    }
}
