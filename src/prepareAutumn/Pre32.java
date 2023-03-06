package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

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

    /**
     * practice
     * */
    public int longestValidParentheses2(String s) {
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < len; i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
    /**
     * DP
     * */
    public int longestValidParentheses3(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 1; i < len; i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                }else if (i > dp[i - 1] + 1 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * practice
     * 22-08-2822点56分
     * */
    public int longestValidParentheses4(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 1; i < len; i++){
            if (s.charAt(i) == ')'){
                if (s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int longestValidParentheses5(String s) {
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if (ch == ')'){
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }else{
                stack.push(i);
            }
        }
        return ans;
    }
    /**
     * practice
     * */
    public int longestValidParentheses6(String s) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
