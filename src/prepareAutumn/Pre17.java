package prepareAutumn;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-13 21:28
 */
public class Pre17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return null;
        }
        Map<Character, char[]> map = new HashMap<Character, char[]>(){{
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }};

        List<String> ans = new ArrayList<>();
        dfs(digits, new StringBuffer(), 0, ans, map);
        return ans;
    }

    private void dfs(String digits, StringBuffer sb, int index, List<String> ans, Map<Character, char[]> map) {
        if (index >= digits.length()){
            return;
        }
        if (sb.length() == digits.length()){
            ans.add(new String(sb));
            return;
        }
        for (int i = index; i < digits.length(); i++){
            for (char ch : map.get(digits.charAt(index))){
                sb.append(ch);
                dfs(digits, sb, i + 1, ans, map);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Pre17 pre17 = new Pre17();
        pre17.letterCombinations("23");
    }
}
