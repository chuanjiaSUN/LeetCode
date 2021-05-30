package Arrays.day23;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-29 14:15
 */
public class exercise611 {
    //双指针
    public int triangleNumber(int[] nums) {
        int length = nums.length;
        if(length < 3) return 0;
        qSort(nums);
        int answer = 0;
        for(int i = 0; i < length - 2 ; i++)
        {
            int k = i + 2;
            for(int j = i + 1; j < length - 1 && nums[i] != 0; j++)
            {
                while( k < length && nums[i] + nums[j] > nums[k])
                {
                    k++;
                }
                answer += k - j - 1;
            }
        }
        return answer;
    }

    //法2 二分法
    public int triangleNumber1(int[] nums)
    {
        int length = nums.length;
        if(length < 3 ) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < length - 2; i++)
        {
            int k = i + 2;
            for(int j = i + 1; j < length - 1; j++)
            {
                k = binarySearch(nums, k, length - 1, nums[i] + nums[j]);
                count += k - j - 1;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while(r >= l && r < nums.length)
        {
            int mid = l + ( r - l) / 2;
            if(nums[mid] >= target)
            {
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public void qSort(int[] nums)
    {
        QuickSort(nums, 0, nums.length - 1);
    }

    private void QuickSort(int[] nums, int low, int high) {
        if(low < high)
        {
            int pivot = getPivotKeu(nums,low,high);
            QuickSort(nums,low,pivot - 1);
            QuickSort(nums,pivot  + 1,high);
        }
    }

    private int getPivotKeu(int[] nums, int low, int high) {
        int pivot = nums[low];
        while(low < high)
        {
            while (high > low && nums[high] >= pivot)
            {
                high--;
            }
            swap(nums,low,high);
            while(high > low && nums[low] <= pivot)
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
        int[]  nums = {1,2,3,4,5,6};
        exercise611 e = new exercise611();
        int i = e.triangleNumber1(nums);
        System.out.println(i);
    }
}
