package String.day15;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-12 10:04
 */
public class exercise520 {
    public boolean detectCapitalUse(String word) {
        int left = 0;
        boolean isAllLower = true;
        boolean isAllUpper = true;
        if (word.charAt(left) - 'a' >= 0 && word.charAt(left) - 'z' <=0)
        {
            int cur = left;
            while (cur < word.length())
            {
                if (word.charAt(cur ) - 'a' < 0 || word.charAt(cur) - 'z' > 0) isAllLower = false;
                cur ++;
            }
            return isAllLower;
        }else if (word.charAt(left) - 'A' >=0 && word.charAt(left - 'Z') <= 0)
        {

            for (int i = left + 1; i < word.length(); i++)
            {
                if (word.charAt(i) - 'a' < 0 || word.charAt(i) - 'z' > 0) isAllLower = false;
                if (word.charAt(i) - 'A' < 0 || word.charAt(i) - 'Z' > 0) isAllUpper = false;
            }
            return isAllLower||isAllUpper;
         }
        return false;
    }

    public static void main(String[] args) {
    }
}
