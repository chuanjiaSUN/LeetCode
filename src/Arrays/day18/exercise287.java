package Arrays.day18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 *
 * 输入：nums = [1,1,2]
 * 输出：1
 * @create 2021-03-24 12:20
 */
public class exercise287 {
    //哈希表
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],1);
            }else{
                return nums[i];
            }
        }
        return 0;
    }
    //二进制
    public int findDuplicate1(int[] nums){
        int length = nums.length,answer = 0;
        int bit_Max = 31;
        while(((length-1)>>bit_Max) == 0)
        {
            bit_Max -= 1;
        }
        for(int bit=0;bit<=bit_Max;bit++)
        {
            int x=0,y=0; //bit表示第几位
            for(int i=0;i<length;i++)
            {
                if((nums[i] & (1<<bit)) != 0)
                {
                    x += 1;// nums数组中的数 第 i 位 不为0
                }
                if( i>=1 && ((i & (1<<bit))!=0))
                {
                    y += 1;// 1-n中的数，第i位不为0
                }
            }
            if(x > y)//说明重复的数第i位位1
            {
                answer |= 1<<bit;
            }
        }
        return answer;
    }

    //法3  Floyd判圈算法，快慢指针 慢指针每次走1步，快指针每次走2步,对 下标与对应数组值连边，当存在重复的值时，一定形成环。
    public int findDuplicate2(int[] nums)
    {
        int slow = 0,fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);//找到相遇点
        slow = 0;
        while(slow != fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    //法3 二分查找
    public int findDuplicate3(int[] nums){
        int length = nums.length;
        int l=1,r = length - 1,ans = -1;
        while(l<=r)
        {
            int mid = l + (r - l)/2;
            int cnt = 0;
            for(int i=0;i<length;i++)//比较数组中比中间的数小的个数
            {
                if(nums[i] < mid)
                {
                    cnt++;
                }
            }
            if(cnt <= mid)
            {
                l = mid + 1;
            }else{
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
