package dynamicPlan;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-05 9:54
 */
public class Exe42 {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0)
        {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++)
        {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int ret = 0;
        for (int i = 0; i < n; i++)
        {
            ret += (Math.min(left[i], right[i]) - height[i]);
        }
        return ret;
    }

    /**单调栈*/
    public int trap1(int[] height)
    {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++)
        {
            while (!stack.isEmpty() && height[stack.peek()] < height[i])
            {
                int top = stack.pop();
                if (stack.isEmpty())
                {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.max(left, height[i]) - height[top];
                ans += curHeight * curWidth;
            }
            stack.push(i);
        }
        return ans;
    }
}
