package Arrays.day17;

/**
 * @author sunchuanjia
 * @Description 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]

 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

 * @create 2021-03-23 10:56
 */
public class exercise238 {

    //暴力法，时间复杂度N*n
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length == 0 || nums == null) return new int[]{};
        int[] ans = new int[length];
        int i=0;
        while(i<length)
        {
            int answer=1;
            int right = i + 1;
            while(right<length)
            {
                answer *= nums[right];
                right++;
            }
            int left = i - 1;
            while(left >= 0)
            {
                answer *= nums[left];
                left--;
            }
            ans[i] = answer;
            i++;
        }
        return ans;
    }
    //法2 左右乘积列表
    public int[] productExceptSelf1(int[] nums)
    {
        int length = nums.length;
        if(length==0)return new int[]{};
        int[] answer = new int[length];
        int[] L = new int[length];
        int[] R = new int[length];

        L[0] = 1;
        R[length-1] = 1;

        for(int i = 1;i<length;i++)
        {
            L[i] = L[i-1] * nums[i-1];
        }
        for(int i=length-2;i>=0;i--)
        {
            R[i] = R[i+1] * nums[i+1];
        }

        for(int i=0;i<length;i++)
        {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
    //法3 用一个输出数组分别作为左边和右边子数组乘积
    public int[] productExceptSelf2(int[] nums)
    {
        int length = nums.length;
        if(length == 0 || nums == null)
        {
            return new int[]{};
        }
        int[] answer = new int[length];
        //先将answer作为左边数组乘积
        answer[0] = 1;
        for(int i=1;i<length;i++)
        {
            answer[i] = answer[i-1]*nums[i-1];
        }

        //讲answer作为右边数组乘积
        int R= 1;
        for(int i=length-1;i>=0;i--)
        {
            answer[i] = answer[i] * R;
            R *= nums[i];//R跟踪右边数的乘积
        }
        return answer;
    }

    //法3 当指针往中间移动时一个循环内计算左右两边乘积，指针错过时，乘积成了左右两边的乘积
    public int[] productExceptSelf3(int[] nums){
        int length = nums.length;
        if(length == 0 || nums == null) return new int[]{};
        int pre = 1, post = 1;
        int[] answer = new int[length];
        for(int i=0;i<length;i++)
        {
            answer[i] = 1;
        }
        for(int i=0;i<length;i++)
        {
            answer[i] *= pre;
            answer[length-i-1]*=post;
            pre *= nums[i];//pre未重合时，pre,post分别算的左边和右边的乘积
            post *= nums[length-i-1];
        }
        return answer;
    }


    public static void main(String[] args) {
        exercise238 e = new exercise238();
        int[] nums = {0,0};
        int[] ints = e.productExceptSelf(nums);
        for(int i:ints)
        {
            System.out.println(i);
        }
    }
}
