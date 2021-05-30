package Arrays.day23;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-29 20:08
 */
public class InsertSortTest {
    public void insertSort(int[] nums)
    {
        int length = nums.length;
        if( length == 0 ) return;
        int left,right;
        for(left = 1; left < length; left++)
        {
            if(nums[left] < nums[left - 1])
            {
                int wife = nums[left];//哨兵
                for(right = left - 1; nums[right] > wife; right--)
                {
                    nums[right + 1] = nums[right];
                }
                nums[right + 1] = wife;
            }
        }
    }
}
