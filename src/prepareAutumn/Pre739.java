package prepareAutumn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-14 23:11
 */
public class Pre739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        int index = len - 1;
        for (int i = len - 1; i >= 0; i--){
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                ans[index--] = 0;
            }else{
                ans[index--] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
