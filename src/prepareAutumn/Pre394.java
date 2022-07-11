package prepareAutumn;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-07 22:44
 */
public class Pre394 {
    int ptr;
    public String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        ptr = 0;
        LinkedList<String> stack = new LinkedList<>();

        while (ptr < len){
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)){
                String digit = getDigit(s);
                stack.addLast(digit);
            }else if (Character.isLetter(cur) || cur == '['){
                stack.addLast(String.valueOf(s.charAt(ptr++)));
            }else{
                ptr++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.removeLast())){
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                stack.removeLast();
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                while (repTime-- > 0){
                    t.append(o);
                }
                stack.addLast(t.toString());
            }
        }
        return getString(stack);
    }

    private String getString(LinkedList<String> sub) {
        StringBuffer ret = new StringBuffer();
        while (!sub.isEmpty()){
            ret.append(sub.pop());
        }
        return ret.toString();
    }

    private String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))){
            sb.append(s.charAt(ptr));
            ptr++;
        }
        return sb.toString();
    }
}
