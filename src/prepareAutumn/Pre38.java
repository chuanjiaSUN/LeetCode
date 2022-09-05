package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-08-01 22:49
 */
public class Pre38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++){
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < str.length()){
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)){
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }
}