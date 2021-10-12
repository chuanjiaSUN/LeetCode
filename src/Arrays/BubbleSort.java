package Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 21:30
 */
public class BubbleSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len - 1; i++)
        {
            for (int j = i + 1; j < len; j++)
            {
                if (nums[i] > nums[j])
                {
                    swap(nums, i, j);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort2(int[] nums)
    {
        if (nums == null && nums.length == 0)
        {
            return;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++)
        {
            for(int j = len - 2; j >= i; j--)
            {
                if (nums[j] > nums[j + 1])
                {
                    swap(nums, j ,j  + 1);
                }
            }
        }
    }

    public void sort3(int[] nums)
    {
        boolean flag = true;
        int len = nums.length;
        for (int i = 0; i < len - 1 && flag; i++)
        {
            flag = false;
            for (int j = len - 2; j >= i; j--)
            {
                if (nums[j] > nums[j + 1])
                {
                    swap(nums, j , j + 1);
                    flag = true;
                }
            }
        }
    }

    public void sort4(int[] nums)
    {
        int n = nums.length;
        boolean flag = true;
        for (int i = 0; i < n  && flag; i++)
        {
            flag = false;
            for (int j = n - 2; j >= i; j--)
            {
                if (nums[j] > nums[j + 1])
                {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10,1,22,13,43,11,53,-1,3,6,99,7};
        BubbleSort b = new BubbleSort();
        b.sort4(nums);
        for (int num : nums)
        {
            System.out.print(num + ",");
        }
    }
}
