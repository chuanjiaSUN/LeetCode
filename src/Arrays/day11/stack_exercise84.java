package Arrays.day11;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @create 2021-03-17 9:43
 */
public class stack_exercise84 {
    //法1 枚举宽度
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int left,right;//左边界右边界
        int answer = 0;
        for(left=0;left<length;left++)
        {
            int minHeight = heights[left];
            for(right=left;right<length;right++)
            {
                minHeight = Math.min(minHeight,heights[right]);
                answer = Math.max(answer,(right-left+1)*minHeight);
            }
        }
        return answer;
    }

    //法2 枚举高度
    public int largestRectangleArea1(int[] heights){
        int length = heights.length;
        //左边界右边界
        int answer = 0,mid;
        //从一个点往两边枚举高度，以他作为基准
        for(mid=0;mid<length;mid++)
        {
            int left=mid,right=mid;
            while(left - 1>=0 && heights[left-1]>=heights[mid])
            {
                left--;
            }
            while(right + 1 < length && heights[right + 1]>=heights[mid])
            {
                right++;
            }
            answer = Math.max(answer,heights[mid]*(right-left+1));
        }
        return answer;
    }

    //法3 通过法2优化，寻找每一个位置形成矩形的左边界和右边界--->>>使用单调栈
    public int largestRectangleArea2(int[] heights)
    {
        int length = heights.length;
        int[] leftBound = new int[length];
        int[] rightBound = new int[length];

        Stack<Integer> stack = new Stack<>();
        //寻找左边界
        for(int i=0;i<length;i++)
        {
            //当左边比自己高时，左边元素出栈
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i])
            {
                stack.pop();
            }
            //左边第一个比自己低的柱子
            leftBound[i] = (stack.isEmpty() ? -1:stack.peek());
            stack.push(i);
        }

        stack.clear();
        //寻找右边界
        for(int i=length-1;i>0;i--)
        {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()])
            {
                stack.pop();
            }
            rightBound[i] = (stack.isEmpty()? length:stack.peek());
            stack.push(i);
        }

        int answer = 0;
        for(int i=0;i<length;i++)
        {
            answer = Math.max(answer,(rightBound[i]-leftBound[i]-1)*heights[i]);
        }
        return answer;
    }

    //法4 单调栈 + 常数优化，只遍历依次，当i出栈时，让它出栈的位置是它的右边界
    public int largestRectangleArea3(int[] heights){
        int length = heights.length;
        int[] leftBound = new int[length];
        int[] rightBound = new int[length];
        Arrays.fill(rightBound,length);

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<length;i++)
        {
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()])
            {
                rightBound[stack.peek()] = i;//让它出栈的位置是右边第一个低于它的柱子
                stack.pop();
            }
            leftBound[i] = stack.isEmpty()? -1:stack.peek();
            stack.push(i);
        }

        int answer = 0;
        for(int i=0;i<length;i++)
        {
            answer = Math.max(answer,(rightBound[i] - leftBound[i] - 1)*heights[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        stack_exercise84 e = new stack_exercise84();
        int[] height = {2,1,5,6,2,3};
        int i = e.largestRectangleArea1(height);
        System.out.println(i);
    }
}
