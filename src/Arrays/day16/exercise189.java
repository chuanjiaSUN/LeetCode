package Arrays.day16;

/**
 * @author sunchuanjia
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]

 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * @create 2021-03-22 16:34
 */
public class exercise189 {
    public void rotate(int[] nums, int k) {
        int[] olds = new int[k];
        int length = nums.length;
        int cur=0;
        for(int i=length-k;i<length;i++)
        {
            olds[cur++] = nums[i];
        }
        int newCur = length - 1;
        for(int i= length-k-1;i>0;i--)
        {
            nums[newCur--] = nums[i];
        }
        for(int i=0;i<k;i++)
        {
            nums[i] = olds[i];
        }
    }

    //法2 数组翻转
    public void rotate1(int[] nums, int k){
        int length = nums.length;
        k = k % length;
        reverse(nums,0,length-1);
        reverse(nums,0,k - 1);
        reverse(nums,k,length-1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left<right)
        {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }
    }

}
