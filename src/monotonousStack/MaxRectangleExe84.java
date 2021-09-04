package monotonousStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-04 9:49
 */
public class MaxRectangleExe84 {
    /**枚举宽*/
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int ans = 0;
        for (int left = 0; left < length; left++)
        {
            int minHeight = Integer.MAX_VALUE;
            for (int right = left; right < length; right++)
            {
                minHeight = Math.min(minHeight, heights[right]);
                ans = Math.max(ans, minHeight * (right - left + 1)) ;
            }
        }
        return ans;
    }
    /**枚举高*/
    public int largestRectangleArea1(int[] heights)
    {
        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n; mid++)
        {
            int height = heights[mid];
            int left = mid, right = mid;
            while (left - 1 >= 0 && heights[left - 1] >= height)
            {
                left--;
            }
            while (right + 1 < n && heights[right + 1] >= height)
            {
                right++;
            }
            ans = Math.max(ans, height * (right - left + 1));
        }
        return ans;
    }
    /**单调栈*/
    public int largestRectangleArea2(int[] heights)
    {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> monotonousStack = new Stack<>();
        for (int i = 0 ; i < n; i++)
        {
            while (!monotonousStack.isEmpty() && heights[monotonousStack.peek()] >= heights[i])
            {
                monotonousStack.pop();
            }
            left[i] = (monotonousStack.isEmpty() ? -1 : monotonousStack.peek());
            monotonousStack.push(i);
        }
        monotonousStack.clear();
        for (int i = n - 1; i>=0; i--)
        {
            while (!monotonousStack.isEmpty() && heights[monotonousStack.peek()] >= heights[i])
            {
                monotonousStack.pop();
            }
            right[i] = (monotonousStack.isEmpty() ? n : monotonousStack.peek());
            monotonousStack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
        {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
    /**单调栈2*/
    public int largestRectangleArea3(int[] heights)
    {
        int len = heights.length;
        if (len == 0)
        {
            return 0;
        }
        int res = 0;
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>(len);
        stack.addLast(0);

        for (int i = 0; i < len; i++)
        {
            while (heights[i] < heights[stack.peekLast()])
            {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }
}
