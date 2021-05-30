package String.day02;

import java.util.HashMap;
import java.util.Map;
import java.util.UnknownFormatConversionException;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-20 9:41
 */
public class exercise8 {
    public int myAtoi(String s) {
        if("".equals(s))return 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        double ans = 0;
        char flag = ' ';
        int i = 0;
        while (i < length && chars[i] == ' ')
        {
            i++;
        }
        if (flag == ' ' && i < length && (chars[i] == '+' || chars[i] == '-'))
        {
            flag = chars[i++];
        }
        for ( ; i < length; i++)
        {
            if ( chars[i] >= '0' && chars[i] <= '9')
            {
                int num = chars[i] - '0';
                ans = ans * 10 + num ;
            }else{
                break;
            }
        }
        if (flag == '-') ans = ans * -1;
        if (ans < Integer.MIN_VALUE) ans = Integer.MIN_VALUE;
        if (ans > Integer.MAX_VALUE) ans = Integer.MAX_VALUE;
        return (int)ans;
    }
    //法2 自动机
    public int myAtoi1(String s)
    {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            automaton.get(s.charAt(i));
        }
        return (int)(automaton.sign * automaton.ans);
    }
    class Automaton{
        private int sign = 1;
        private long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>(){
            {
                put("start", new String[]{"start", "signed", "in_number", "end"});
                put("signed", new String[]{"end", "end", "in_number", "end"});
                put("in_number", new String[]{"end", "end", "in_number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };
        public void get(char c)
        {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state))
            {
                ans = ans *10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min( ans, -(long)Integer.MIN_VALUE);
            }else if("signed".equals(state))
            {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ')
            {
                return 0;
            }
            if (c == '+' || c == '-')
            {
                return 1;
            }
            if (Character.isDigit(c))
            {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        exercise8 e = new exercise8();
        int i = e.myAtoi("");
        System.out.println(i);
    }
}
