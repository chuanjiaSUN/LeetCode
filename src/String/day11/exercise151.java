package String.day11;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-30 16:17
 */
public class exercise151 {
//    输入："the sky is blue"
//    输出："blue is sky the"

    //法1 调用API
    public String reverseWords(String s) {
        s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    //法2 双端队列
    public String reverseWords1(String s)
    {
        int left = 0, right = s.length() - 1;
          //去除两边空格
        while (left < right && s.charAt(left) == ' ')left++;
        while (left < right && s.charAt(right) == ' ') right--;
         //将单词插入队列
        Deque<String> deque = new ArrayDeque<>();
        StringBuffer sb = new StringBuffer();

        while (left <= right)
        {
            if (sb.length() != 0 && s.charAt(left) == ' ')
            {
                deque.offerFirst(sb.toString());
                sb.setLength(0);
            }else if (s.charAt(left) != ' ')
            {
                sb.append(s.charAt(left));
            }
            left++;
        }
        deque.offerFirst(sb.toString());

        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        exercise151 e = new exercise151();
        String str = e.reverseWords("the sky is blue");
        System.out.println(str);

    }
}
