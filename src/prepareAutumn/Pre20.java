package prepareAutumn;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-13 21:53
 */
public class Pre20 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))){
                if (!stack.isEmpty() && stack.peek().equals(map.get(s.charAt(i)))){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    /**
     * practice
     * */
    public boolean isValid1(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        int len = s.length();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (!stack.isEmpty() && stack.peek().equals(map.get(ch))){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
