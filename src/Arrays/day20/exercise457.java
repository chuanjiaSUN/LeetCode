package Arrays.day20;

import java.util.TreeMap;

/**
 * @author sunchuanjia
 * @Description 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 *
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果 nums[i] 是负数，向后 移动 nums[i] 步
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。

 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 *
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 *
 * @create 2021-03-26 14:26
 */
public class exercise457 {
    //快慢指针
    //存在循环时条件 i + nums[i] = length + 1 / 0
    public boolean circularArrayLoop(int[] nums) {
       int length = nums.length;
       if(length==0) return false;
       for(int i=0;i<length;i++)
       {
           if(nums[i]==0) continue;//剪枝
           int slow,fast;//记录快慢指针走到哪了
           int j = i, k=i;//快慢指针

           while(true)
           {
               slow = j;//慢指针走一步
               j = (j + nums[j] + 5000*nums.length) % nums.length;// +5000*length 是为了确保下标不越界
               if(nums[slow] * nums[j] < 0 || nums[j] == 0 || slow == j)//剪枝
               {
                   setZero(nums,i);
                   break;
               }
               fast = k;//快指针走2步
               k = (k + nums[k] + 5000*length) % length;//快指针走到一步后的位置
               if(nums[fast] * nums[k] <0 || nums[k] == 0 || fast == k)//剪枝
               {
                   setZero(nums,i);
                   break;
               }
               fast = k;//快指针走一步后的位置
               k = (k + nums[k] + 5000*length) % length;//快指针走2步后的位置
               if(nums[fast] * nums[k] <0 || nums[k] ==0 || fast ==k)//剪枝
               {
                   setZero(nums,i);
                   break;
               }
               if(j == k)
               {
                   return true;
               }
           }
       }
       return false;
    }

    private void setZero(int[] nums, int i) {
        int j;
        while(true)
        {
            j = ( i + nums[i] + 5000*nums.length) %nums.length;
            if(nums[j] == 0 || nums[i]*nums[j]<0)
            {
                nums[i] = 0;
                break;
            }
            nums[i] = 0;
            i = j;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        exercise457 e = new exercise457();
        boolean b = e.circularArrayLoop(nums);
        System.out.println(b);
    }

}
