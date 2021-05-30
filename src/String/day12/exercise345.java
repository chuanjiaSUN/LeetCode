package String.day12;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-07 17:14
 */
public class exercise345 {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        while (left < right)
        {
            while (!isVow(chars[left]) && left < right)
            {
                left++;
            }
            while (!isVow(chars[right]) && left < right)
            {
                right--;
            }
            char temp = chars[right];
            chars[right] = chars[left];
            chars[left] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public boolean isVow(char ch)
    {
        return ch == 'a' || ch == 'A' || ch == 'i' || ch =='I'
                || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U' || ch == 'e' || ch == 'E';
    }
}
