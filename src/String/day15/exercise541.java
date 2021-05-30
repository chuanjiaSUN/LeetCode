package String.day15;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-13 10:04
 */
public class exercise541 {
    public String reverseStr(String s, int k) {
       char[] chars = s.toCharArray();
       for (int start = 0; start < chars.length; start += 2 * k)
       {
           int i = start, j = Math.min(start + k -1, chars.length - 1);
           while ( i < j)
           {
               char temp = chars[i];
               chars[i++] = chars[j];
               chars[j--] = temp;
           }
       }
       return new String(chars);
    }
}
