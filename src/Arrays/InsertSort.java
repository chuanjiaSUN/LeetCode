package Arrays;

import java.awt.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 21:43
 */
public class InsertSort {
    public void sort(int[] nums)
    {
        int len = nums.length;
        int j;
        for (int i = 1; i < len - 1; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                int temp = nums[i];
                for (j = i - 1; j >= 0 && nums[j] > temp; j--)
                {
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,-1,9,6, 4,4,3,2,22,32};
        InsertSort sor = new InsertSort();
        sor.sort(nums);
        for(int num : nums)
        {
            System.out.print(num + ",");
        }
    }
}
