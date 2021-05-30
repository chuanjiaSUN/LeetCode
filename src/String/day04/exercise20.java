package String.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-22 9:42
 */
public class exercise20 {
    //栈1
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            if ( !stack.isEmpty())
            {
                if (s.charAt(i) == ')')
                {
                    if (stack.peek() == '(')
                    {
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }else if (s.charAt(i) == ']')
                {
                    if (stack.peek() == '[')
                    {
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }else if (s.charAt(i) == '}')
                {
                    if (stack.peek() == '{')
                    {
                        stack.pop();
                    }else{
                        stack.push(s.charAt(i));
                    }
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
    //栈2
    public boolean isValid1(String s)
    {
        int n = s.length();
        if (n % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<Character, Character>(){
            {
                put(')','(');
                put(']','[');
                put('}','{');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if (map.containsKey(c))
            {
                if (stack.isEmpty() || stack.peek() != map.get(c))
                {
                    return false;
                }
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        exercise20 e = new exercise20();
        boolean valid = e.isValid("()[]{}");
        System.out.println(valid);
    }

}
