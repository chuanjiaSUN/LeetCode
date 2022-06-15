package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;

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
}
