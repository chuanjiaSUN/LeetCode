package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-14 22:23
 */
public class Pre32 {
    /**动态规划*/
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int maxAnswer = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if (i - dp[i - 2] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxAnswer = Math.max(maxAnswer, dp[i]);
            }
        }
        return maxAnswer;
    }

    /**栈*/
    public int longestValidParentheses1(String s) {
        if (s == null){
            return 0;
        }
        int maxAns = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxAns = Math.max(maxAns, i - stack.peek());
                }
            }
        }
        return maxAns;
    }
}
