package Arrays.day24;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-30 13:41
 */
public class InsertS {
    //插排
    public void InsertOrder(int[] nums)
    {
        int length = nums.length;
        if( length == 0 ) return;
        int left,right;
        for(left = 1; left < length; left++)
        {
            if(nums[left] < nums[left - 1])
            {
                int wife = nums[left];
                for(right = left - 1;nums[right] > wife; right--)
                {
                    nums[right + 1] = nums[right];
                }
                nums[right + 1] = wife;
            }
        }
    }

    public void QuickS(int[] nums)
    {
        QuickSort(nums,0,nums.length-1);
    }

    //快排 ， 选择排序
    private void QuickSort(int[] nums, int low, int high) {
        if(low < high)
        {
            int pivot = partition(nums,low,high);
            QuickSort(nums,low,pivot - 1);
            QuickSort(nums,pivot + 1,high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        while(low < high)
        {
            while(low < high && nums[high] >= pivotKey)
            {
                high--;
            }
            swap(nums,low,high);
            while(low < high && nums[low] <= pivotKey)
            {
                low++;
            }
            swap(nums,low,high);
        }
        return low;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,47,7,6,4,10,98,5,13};
        InsertS e = new InsertS();
//        e.QuickS(nums);
        e.InsertOrder(nums);
        for(int num:nums)
        {
            System.out.println(num);
        }
    }

}
