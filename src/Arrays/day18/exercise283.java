package Arrays.day18;

/**
 * @author sunchuanjia
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]

 * @create 2021-03-24 12:05
 */
public class exercise283 {
    //双指针
    public void moveZeroes(int[] nums) {
        int p0=0,p1=0;
        int length = nums.length;
        if(length==0||nums==null) return;
        while(p1<length)
        {
           if(nums[p1] != 0)
           {
               swap(nums,p0,p1);
               p0++;
           }
           p1++;
        }
    }

    private void swap(int[] nums, int p0, int p1) {
        int temp = nums[p0];
        nums[p0] = nums[p1];
        nums[p1] = temp;
    }
}
