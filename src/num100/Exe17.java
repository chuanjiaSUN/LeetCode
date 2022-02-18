package num100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 16:08
 */
public class Exe17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0){
            return combinations;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3',"def");
                put('4',"ghi");
                put('5', "jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }};
        backTrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private void backTrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()){
            combinations.add(combination.toString());
            return;
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++){
                combination.append(letters.charAt(i));
                backTrack(combinations, phoneMap,digits, index + 1, combination);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}
