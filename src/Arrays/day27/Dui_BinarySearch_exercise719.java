package Arrays.day27;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-02 13:02
 */
public class Dui_BinarySearch_exercise719 {

    //二分法 + 前缀和
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int WIDTH = 2 * nums[nums.length - 1];

        //multiplicity[i] = number of nums[i] == nums[j] ( j < i)
        int[] multiplicity = new int[nums.length];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] == nums[i-1])
            {
                multiplicity[i] = 1 + multiplicity[i-1];
            }
        }

        //prefix[v] = number of values <= v
        int[] prefix = new int[WIDTH];
        int left = 0;
        for( int i = 0; i < WIDTH; i++)
        {
            while (left < nums.length && nums[left] == i) left++;
            prefix[i] = left;
        }

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++)
            {
                count += prefix[nums[i] + mid] - prefix[nums[i]] + multiplicity[i];
            }
            //count = number of paris with distance <= mid
            if(count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    //法2 二分查找 + 双指针
    //使用双指针计算出 所有小于等于guess的距离对数目，维护left 和 right
    //  1.先对数组排序，找出最大距离、最大距离
    //  2.在最大距离与最小距离中寻找满足题目要求的距离
    //  3.题目要求的距离为第k小的距离,因此在二分法找距离的过程中，需要遍历数组统计各个小于mid距离的个数
    //  4.结束条件即为找到第k个距离了，此时循环退出时low也走到了那个距离的位置
    public int smallestDistancePair1(int[] nums, int k)
    {
        Arrays.sort(nums);

        int low = 0;//最小距离
        int high = nums[nums.length - 1] - nums[0];//最大距离
        while( low < high)
        {
            int mid = low + (high - low) / 2;
            int count = 0, left = 0;
            //求出数组中距离小于Mid的距离对的数量，使用双指针
            for(int right = 0; right < nums.length; right++)
            {
                while(nums[right] - nums[left] > mid) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mid
            if(count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }


    public int smallestDistancePair2(int[] nums, int k)
    {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while( low < high)
        {
            int mid = low + (high - low ) / 2;
            int count = 0, left = 0;
            //双指针寻找Nums数组中距离小于mid的数组对
            for( int right = 0; right < nums.length; right++)
            {
                while( right < nums.length && nums[right] - nums[left] > mid) left++;//数组是升序，可以这样用双指针
                count += right - left;
            }
            if( count >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
