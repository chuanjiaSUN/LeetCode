package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-11 22:20
 */
public class Pre58 {
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        int len = trim.length();
        int ans = 0;
        for (int i = len - 1; i >= 0; i--){
            if (trim.charAt(i) != ' '){
                ans++;
            }else{
                break;
            }
        }
        return ans;
    }
}
