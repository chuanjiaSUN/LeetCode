package String.day10;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-29 14:58
 */
public class exercise125 {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0, right = length - 1;
         s = s.toLowerCase();
        while ( left < right )
        {
            while (left < right && !check(s.charAt(left)))
            {
                left++;
            }
            while (left < right && !check(s.charAt(right)))
            {
                right--;
            }
            if (left <= right && s.charAt( left ) == s.charAt( right))
            {
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean check(char c) {
        if ((c >= 'a' && c <= 'z') || ( c >= '0' && c <= '9')) return true;
        else return false;
    }

    public static void main(String[] args) {
        exercise125 e = new exercise125();
        boolean palindrome = e.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}
