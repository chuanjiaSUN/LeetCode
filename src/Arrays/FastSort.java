package Arrays;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 21:07
 */
public class FastSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0)
        {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        int mid;
        if (low < high)
        {
            mid = getMidValue(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

    private int getMidValue(int[] nums, int low, int high) {
        int midValue = nums[low];
        while (low < high)
        {
            while (low < high && nums[high] >= midValue)
            {
                high--;
            }
            swap(nums, low, high);
            while (low < high && nums[low] <= midValue)
            {
                low++;
            }
            swap(nums, low, high);
        }
        return low;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public void Qsort(int[] nums)
    {
        quicklySort(nums, 0, nums.length - 1);
    }

    private void quicklySort(int[] nums, int start, int end) {
        int mid;
        if (start < end)
        {
            mid = findMid(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }

    private int findMid(int[] nums, int start, int end) {
        int dummy = nums[start];
        while (start < end)
        {
            while (start < end && nums[end] >= dummy)
            {
                end--;
            }
            swap(nums, start, end);
            while (start < end && nums[start] <= dummy)
            {
                start++;
            }
            swap(nums, start, end);
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,-1,9,6, 4,4,3,2,22,32};
        FastSort fastSort = new FastSort();
        fastSort.Qsort(nums);
        for(int num : nums)
        {
            System.out.print(num + ",");
        }
    }
}
