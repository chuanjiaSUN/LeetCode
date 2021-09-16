package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-16 15:31
 */
public class Exe467 {
    /**滑动窗口*/
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] array = p.toCharArray();
        int count = 0;
        int length = array.length;
        for (int i = 0; i < length; i++)
        {
            if (i > 0 && (array[i] - array[i - 1] - 1) %  26 == 0)
            {
                count++;
            }else{
                count = 1;
            }
            dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], count);
        }
        int result = 0;
        for (int i : dp)
        {
            result += i;
        }
        return result;
    }
}
