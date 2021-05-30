package Arrays.day10;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 * @create 2021-03-16 9:55
 */
public class PaiXu_exercise75 {
    //法1 调用API
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
    //法2 冒泡
    public void sortColors1(int[] nums){
        int length = nums.length;
        boolean changed = true;
        for(int i=1;i<length;i++)
        {
            changed = false;
            for(int j =length-1;j >= i && changed ;j--)
            {
                if(nums[j]>nums[j+1])
                {
                    swap(nums,j,j+1);
                    changed = true;
                }
            }
        }
    }



    public void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //法3 单指针，两次遍历，分别将0，1交换到前面，一个指针表示该交换的位置
    public void sortColors2(int[] nums){
        int length = nums.length;
        int ptr = 0;
        for(int i=0;i<length;i++)
        {
            if(nums[i]==0) {
                swap(nums,i,ptr);
                ptr++;
            }
        }
        for(int i=ptr;i<length;i++)
        {
            if(nums[i] == 1)
            {
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }

    //法4 双指针 两个指针分别用来交换0、1，扫描到0或1时，交换，并且指针后移
    public void sortColors3(int[] nums){
        int length = nums.length;
        int p0 = 0,p1 = 0;
        for(int i =0;i<length;i++)
        {
            if(nums[i]==1)
            {
                swap(nums,i,p1);
                p1++;
            }else if(nums[i]==0){
                swap(nums,i,p0);
                if(p0<p1){
                    swap(nums,i,p1);
                }
                p0++;
                p1++;
            }
        }
    }

    //法5 双指针 两个指针分别用来交换0、2,扫描到0或2时，交换，并且0指针后移，2指针前移
    public void sortColors4(int[] nums){
        int length = nums.length;
        int p0 = 0,p2 = length - 1;
        for(int i=0;i<=p2;i++)
        {
            while (i <= p2 && nums[i]==2)
            {
                swap(nums,i,p2);
                p2--;
            }
            if(nums[i]==0)
            {
                swap(nums,i,p0);
                p0++;
            }
        }
    }
}
