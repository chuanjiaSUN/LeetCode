package Arrays.day05;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）
 *

 * @create 2021-03-10 21:43
 */
public class exercise42 {

    //法1 暴力求解,从左往右遍历数组,找到当前位置最左边的最高柱子，和最右边的最高柱子，可以储水
    public int trap(int[] height) {
        int length = height.length;
        int answer = 0;

        for(int i=1;i<length-1;i++)
        {
            int left_max =0,right_max = 0;
            for(int left=i;left>=0;left--)
            {
                left_max = Math.max(height[left],left_max);
            }
            for(int right=i;right<length;right++)
            {
                right_max = Math.max(height[right],right_max);
            }
            answer += Math.min(left_max,right_max) - height[i];
        }
        return answer;
    }

    //法2 动态规划，分别遍历数组，计算从左到右的最大高度，即左边柱子最大高度；计算从右到左的最大高度，即右边柱子的最大高度
    public int trap1(int[] height){
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        int answer = 0;
        //计算左边柱子的最大高度
        left_max[0] = height[0];
        right_max[size-1] = height[size - 1];
        for(int left=1;left<size;left++)
        {
            if(height[left]>left_max[left-1]){
                left_max[left] = height[left];
            }else{
                left_max[left] = left_max[left - 1];
            }
        }
        //计算从右往左的柱子最大高度
        for(int right=size - 2;right>=0;right--)
        {
            if(height[right]>right_max[right+1])
            {
                right_max[right] = height[right];
            }else{
                right_max[right] = right_max[right + 1];
            }
        }

        //遍历 最大最右柱子数组，计算每个点的蓄水量
        for(int i=0;i<size;i++)
        {
            int bound = Math.min(left_max[i],right_max[i])-height[i];
            answer += bound;
        }

        return answer;
    }

    //法3 用单调栈存储 节点在数组的索引
    //因为从左到右看，只有当某一点左边的柱子高于它，且右边的柱子也高于它，才能储水，即低洼处储水
    //因此用一个单调递减栈存储 遍历数组中高于当前高度的柱子，当遇到比栈顶元素大的柱子后，即可计算储水量，弹出栈顶元素。
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int position=0,right=height.length;
        int answer = 0;
        while(position<right)
        {
            //当遇到大于栈顶的元素时，即可形成低洼，计算蓄水量
            while(!stack.isEmpty() && height[position]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()) break;//栈空了退出循环
                int length = position - stack.peek() - 1;
                int high = Math.min(height[position],height[stack.peek()]) - height[top];
                answer += length * high;
            }
            stack.push(position);
            position++;
        }

        return answer;
    }

    //法4 使用双指针,假设右边存在一个比较高的柱子时，从左到右遍历，若遇到一个比之前遍历过的柱子都高的时，可形成低洼。
    // 假设左边存在一根时同理
    public int trap3(int[] height){
        int left = 0,right = height.length-1;
        int answer = 0;
        int left_max = 0,right_max =0;
        while(left<right)
        {
            //从左到右遍历，假设右边存在一根高的柱子
            if(height[left]<height[right])
            {
                if(height[left]>=left_max)
                {
                    left_max = height[left];

                }else{
                    answer += (left_max - height[left]);
                }
                left++;
            }else{
                //左边存在一根高柱子
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    answer += (right_max - height[right]);
                }
                right--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        exercise42 e = new exercise42();
        int[] height = {4,2,0,3,2,5};
        System.out.println(e.trap(height));
        System.out.println(e.trap1(height));
        System.out.println(e.trap2(height));
        System.out.println(e.trap3(height));
    }
}
