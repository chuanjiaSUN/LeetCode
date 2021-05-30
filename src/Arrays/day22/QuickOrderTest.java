package Arrays.day22;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-28 15:19
 */
public class QuickOrderTest {

    public void qSort(int[] nums)
    {
        QuickSort(nums,0,nums.length-1);
    }
    public void QuickSort(int[] nums,int low, int high)
    {
        int pivot;
        if(low < high)
        {
            pivot = partition(nums,low,high);
            QuickSort(nums, low, pivot - 1);
            QuickSort(nums, pivot + 1, high);
        }
    }


   public int partition(int[] nums, int low, int high)
   {
       int pivotKey;
       pivotKey = nums[low];
       while (low < high)
       {
           while(high > low && nums[high] >= pivotKey)
           {
               high--;
           }
           swap(nums, low, high);//将比枢纽小的交换到低端
           while (low < high && nums[low] <= pivotKey)
           {
                low++;
           }
           swap(nums, low, high);//将比枢纽大的交换到高端
       }
       return low;//返回枢纽所在位置
   }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
   }
   //InsertSort
    public void InsertSort(int[] nums)
    {
        int length = nums.length;
        int left,right;
        for(left = 1;left < length; left++)
        {
            //将更小的查到正确的位置，且left - 1之前的是有序的
            if(nums[left] < nums[left - 1])
            {
               int wife = nums[left];//烧兵
                for(right = left - 1; nums[right] > wife; right--)
                {
                    nums[right + 1] = nums[right];
                }
                nums[right + 1] = wife;
            }
        }
    }


    public static void main(String[] args) {
        QuickOrderTest q = new QuickOrderTest();
        int[] nums = {2,21,4,8,123,4,6,8,9,12,15,3,15,23};
//        q.qSort(nums);
        q.InsertSort(nums);
        for(int num:nums)
        {
            System.out.println(num);
        }
        Arrays.sort(nums);
    }
}
