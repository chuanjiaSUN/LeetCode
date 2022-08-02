package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-15 22:33
 */
public class Pre42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int high = Math.min(height[left], height[i]);
                ans += (high - height[top]) * (i - left - 1);
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * practice
     * */
    public int trap1(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int mid = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int high = Math.min(height[left], height[i]);
                int width = (i - left - 1);
                ans += (high - height[mid]) * width;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * practice
     * */
    public int trap2(int[] height) {
        int len = height.length;
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < len; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int mid = stack.pop();
                if (!stack.isEmpty()){
                    int left = stack.peek();
                    int high = Math.min(height[i], height[left]);
                    ans += (high - height[mid]) * (i - left - 1);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
