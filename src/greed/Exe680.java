package greed;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-16 17:49
 */
public class Exe680 {
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high)
        {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2)
            {
                low++;
                high--;
            }else{
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--)
        {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2)
            {
                return false;
            }
        }
        return true;
    }
}
