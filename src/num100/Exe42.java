package num100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-20 14:20
 */
public class Exe42 {
    //法1 动态规划
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0]; rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++){
            ans +=( Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return ans;
    }
    //法2 单调栈
    public int trap1(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        int ans = 0;
        for (int i = 0; i < len; i++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int cur = i - left - 1;
                int area = cur * (Math.min(height[i], height[left]) - height[top]);
                ans += area;
            }
            stack.push(i);
        }
        return ans;
    }

    //法3 双指针
    public int trap2(int[] height) {
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;
        while (left < right){
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (leftMax < rightMax){
                ans += (leftMax - height[left]);
                left++;
            }else{
                ans += (rightMax - height[right]);
                right--;
            }
        }
        return ans;
    }
}
