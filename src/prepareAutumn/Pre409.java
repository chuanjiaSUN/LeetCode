package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-07 19:50
 */
public class Pre409 {
    public int longestPalindrome(String s) {
            int[] count = new int[128];
            for (char ch : s.toCharArray()){
                count[ch]++;
            }
        int ans = 0;
        for (int num : count){
            ans += num / 2 * 2;
            if (num % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }
        return ans;
    }
}
