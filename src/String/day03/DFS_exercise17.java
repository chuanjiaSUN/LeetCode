package String.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-21 13:56
 */
public class DFS_exercise17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>(){
            {put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
            }
        };
        List<String> ans = new ArrayList<>();
        dfs(ans, map, digits, 0, new StringBuffer());
        return ans;
    }

    private void dfs(List<String> ans, Map<Character, String> map, String digits, int index, StringBuffer combination) {
        if (index == digits.length())
        {
            ans.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++)
            {
                combination.append(letters.charAt(i));
                dfs(ans, map, digits, index + 1, combination);
                combination.deleteCharAt(index);//回溯
            }
        }
    }


}
