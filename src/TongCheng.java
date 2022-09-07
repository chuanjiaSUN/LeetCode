/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-07 19:32
 */
public class TongCheng {
    public String longestPrefix (String s) {
        // write code here
        if (s == null || s.length() == 0){
            return s;
        }
        int len = s.length();
        String ans = "";
        for (int i = 1; i < len; i++){
            String prefix = s.substring(0, i);
            String suffix = s.substring(len - i, len);
            if (prefix.equals(suffix) && prefix.length() > ans.length()){
                ans = prefix;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TongCheng tongCheng = new TongCheng();
        String s = tongCheng.longestPrefix("level");
        System.out.println(s);
    }
}
