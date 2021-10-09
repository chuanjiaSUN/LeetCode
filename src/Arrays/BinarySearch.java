package Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 22:00
 */
public class BinarySearch {
    public int search(int[] nums, int target)
    {
        if (nums == null || nums.length == 0)
        {
            return -1;
        }
        int len = nums.length;
        int low = 0, high = len - 1;
        while (low < high)
        {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target)
            {
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public void quickSort(int[] nums)
    {
        fastSort(nums, 0, nums.length - 1);
    }

    private void fastSort(int[] nums, int low, int high) {
        int mid;
        if (low < high)
        {
            mid = getMid(nums, low, high);
            fastSort(nums, low, mid - 1);
            fastSort(nums, mid + 1, high);
        }
    }

    private int getMid(int[] nums, int low, int high) {
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

    public void bubbleSort(int[] nums)
    {
        int len = nums.length;
        boolean flag = true;
        for (int i = 0 ; i < len && flag; i++)
        {
            flag = false;
            for (int j = len - 2; j >= i; j--)
            {
                if (nums[j] > nums[j + 1])
                {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
        }
    }

    public void insertSort(int[] nums)
    {
        int temp;
        int j;
        int len = nums.length;
        for (int i = 1; i < len; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                temp = nums[i];
                for (j = i - 1; j >= 0 && nums[j] > temp; j--)
                {
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 0, -1, -5, 5, 2, 19,34,23,99,13, 24};
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.insertSort(nums);
        for (int num : nums)
        {
            System.out.print(num + ",");
        }
        int search = binarySearch.search(nums, 2);
        System.out.println();
        System.out.println(search);
    }
}
