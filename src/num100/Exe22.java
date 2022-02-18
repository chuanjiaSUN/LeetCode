package num100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-18 22:28
 */
public class Exe22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, new StringBuffer(), 0, 0, n);
        return ans;
    }

    private void backTrack(List<String> ans, StringBuffer path, int left, int right, int n) {
        if (path.length() == 2 * n){
            ans.add(path.toString());
            return;
        }
        if(left < n){
           path.append('(');
           backTrack(ans, path, left + 1, right, n);
           path.deleteCharAt(path.length() - 1);
        }
        if (right < left){
            path.append(')');
            backTrack(ans, path, left, right + 1, n);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
