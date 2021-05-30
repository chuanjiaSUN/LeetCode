package String.day05;

import sun.security.util.Length;

import java.util.Stack;
import java.util.UnknownFormatConversionException;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-23 11:37
 */
public class DongGui_exercise32 {
    //法1 动态规划
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n];
        int max = 0;
        for (int i = 1; i < n; i++)
        {
            if (s.charAt(i) == ')')
            {
                if (s.charAt(i - 1) == '(')
                {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if ( i - dp[i - 1] > 0 && s.charAt( i - dp[ i - 1] - 1) == '(')
                {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) +2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    //法2 栈
    public int longestValidParentheses1(String s)
    {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }else{
                stack.pop();
                if (stack.empty())
                {
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses2(String s)
    {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push( -1);
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty())
                {
                    stack.push(i);
                }
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
    //法3 不消耗额外空间 记录遍历过程中'('与')'个数
    //但这样会漏掉一种情况，就是遍历的时候左括号的数量始终大于右括号的数量，即 (() ，这种时候最长有效括号是求不出来的。
    public int longestValidParentheses3(String s)
    {
        int left = 0,right = 0,maxLength = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                left++;
            }else{
                right++;
            }
            if (left == right)
            {
                maxLength = Math.max(maxLength, 2 * right);
            }else if (right > left)
            {
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s.charAt(i) == '(')
            {
                left++;
            }else{
                right++;
            }
            if (left == right)
            {
                maxLength = Math.max(maxLength, left * 2);
            }else if (left > right)
            {
                left = 0;
                right = 0;
            }
        }
        return maxLength;
    }
}
