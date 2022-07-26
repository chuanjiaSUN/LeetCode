package prepareAutumn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-26 23:26
 */
public class Pre14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++){
            prefix = longPrefix(prefix, strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String longPrefix(String prefix, String str) {
        int len = Math.min(prefix.length(), str.length());
        int index =0 ;
        while (index < len && prefix.charAt(index) == str.charAt(index)){
            index++;
        }
        return prefix.substring(0, index);
    }
}
