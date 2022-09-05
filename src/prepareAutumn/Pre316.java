package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-28 0:46
 */
public class Pre316 {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++){
            nums[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!vis[ch - 'a']){
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch){
                    if (nums[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }else{
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            nums[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
