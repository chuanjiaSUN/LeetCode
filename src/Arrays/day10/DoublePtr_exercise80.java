package Arrays.day10;

/**
 * @author sunchuanjia
 * @Description 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下：
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *  print(nums[i]);
 * }
 *

 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。
。
 * @create 2021-03-16 11:32
 */
public class DoublePtr_exercise80 {

    //法1 原地删除重复元素
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int count = 1,i=1;
        while(i<length){
            if(nums[i]==nums[i-1])
            {
                count++;
                if(count>2)
                {
                    for(int j=i+1;j<length;j++)
                    {
                        nums[j-1] = nums[j];
                    }
                    i--;
                    length--;
                }
            }else{
                count = 1;
            }
            i++;
        }
        return length;
    }

    //法2 以未重复的元素覆盖重复元素
    public int removeDuplicates1(int[] nums){
        int length = nums.length;
        int count = 1;
        int j=1;
        for(int i=1;i<length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count++;
            }else{
                count=1;
            }

            if(count<=2)//i位置遇到未重复的元素了
            {
              nums[j] = nums[i];//j的位置是要覆盖的元素
              j++;
            }
        }
        return j;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        DoublePtr_exercise80 e = new DoublePtr_exercise80();
        int i = e.removeDuplicates(nums);
        System.out.println(i);
    }
}
