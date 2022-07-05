package prepareAutumn;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.platform.engine.TestTag.isValid;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-05 21:19
 */
public class Pre301 {
    List<String> ans = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                leftRemove++;
            }else if (s.charAt(i) == ')'){
                if (leftRemove == 0){
                    rightRemove++;
                }else{
                    leftRemove--;
                }
            }
        }
        helper(s, 0, leftRemove, rightRemove);

        return ans;
    }

    private void helper(String s, int index, int leftRemove, int rightRemove) {
        if (leftRemove == 0 && rightRemove == 0){
            if (isValidStr(s)){
                ans.add(s);
            }
            return;
        }
        for (int i = index; i < s.length(); i++){
            if (i != index && s.charAt(i) == s.charAt(i - 1)){
                continue;
            }
            if (leftRemove + rightRemove > s.length() - i){
                return;
            }
            if (leftRemove > 0 && s.charAt(i) == '('){
                helper(s.substring(0, i) + s.substring(i + 1), i, leftRemove - 1, rightRemove);
            }
            if (rightRemove > 0 && s.charAt(i) == ')'){
                helper(s.substring(0, i) + s.substring(i + 1), i, leftRemove, rightRemove - 1);
            }
        }
    }

    private boolean isValidStr(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                cnt++;
            }else if (s.charAt(i) == ')'){
                cnt--;
                if (cnt < 0){
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    /**
     * BFS
     * */
    public List<String> removeInvalidParentheses1(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        set.add(s);
        while (true){
            for (String str : set){
                if (isValidStr(str)){
                    ans.add(str);
                }
            }
            if (ans.size() > 0){
                return ans;
            }
            Set<String> nextSet = new HashSet<>();
            for (String str : set){
                for (int i = 0; i < str.length(); i++){
                    if (i > 0 && str.charAt(i) == str.charAt(i - 1)){
                        continue;
                    }
                    if (str.charAt(i) == '(' || str.charAt(i) == ')'){
                        nextSet.add(str.substring(0, i) + str.substring(i + 1));
                    }
                }
            }
            set = nextSet;
        }
    }
}
