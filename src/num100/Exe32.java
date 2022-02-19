package num100;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-19 15:33
 */
public class Exe32 {
    /**法1 栈*/
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int maxAns = 0;
        stack.push(-1);
        int len = s.length();
        for (int i = 0; i < len; i++){
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

    /**法2 动态规划*/
    public int longestValidParentheses1(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int maxLen = 0;
        for (int i = 1; i < len ; i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i > 2 ? dp[i - 2] + 2 : 2);
                }else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    @Test
    public void test(){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
