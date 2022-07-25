package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-24 21:51
 */
public class Pre9 {
    public boolean isPalindrome(int x) {
        String str = x + "";
        int len = str.length();
        int left = 0;
        int right = len - 1;
        while (left < right && str.charAt(left) == str.charAt(right)){
            left++;
            right--;
        }
        return left == right;
    }
}
