package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-21 23:15
 */
public class Pre84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < len; i++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    /**
     * 哨兵
     * */
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < len; i++){
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
