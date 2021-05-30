package String.day03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-21 14:09
 */
public class exercise17_Prac {
    public List<String> letterCombinations(String digits)
    {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        //对map进行深度遍历
        Map<Character, String> phoneMap = new HashMap<Character, String>(){
            {
                put('2',"abc");
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
        dfs(ans, digits, 0, phoneMap, new StringBuffer());
        return ans;
    }

    private void dfs(List<String> ans, String digits, int index, Map<Character, String> phoneMap, StringBuffer combination) {
        if (index == digits.length())
        {
            ans.add(combination.toString());
        }else {
            // StringBuffer用来记录DFS搜索的路径
            char digit = digits.charAt(index);
            String str = phoneMap.get(digit);
            //对digits进行深度遍历
            int length = str.length();
            for (int i = 0; i < length; i++)
            {
                combination.append(str.charAt(i));
                dfs(ans, digits, index + 1, phoneMap, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
