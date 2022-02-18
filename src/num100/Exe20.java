package num100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 21:47
 */
public class Exe20 {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < len ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty() || !stack.peek().equals(map.get(ch))){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
