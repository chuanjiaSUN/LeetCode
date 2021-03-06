package prepareAutumn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-14 21:15
 */
public class Pre22 {
    char[] charArray = {'(', ')'};
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0){
            return ans;
        }
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, 0, 0, ans, 0);
        return ans;
    }

    private void dfs(StringBuilder sb, int n, int left, int right, List<String> ans, int counts) {
        if (counts == 2 * n && sb.length() == n * 2 && left == right){
            ans.add(sb.toString());
        }
        if (counts > 2 * n){
            return;
        }
        if (left < right){
            return;
        }
        for (char ch : charArray){
            if (ch == ')' && left > right){
                sb.append(ch);
                dfs(sb, n, left, right + 1, ans, counts + 1);
                sb.deleteCharAt(sb.length() - 1);
            }else if (ch == '('){
                sb.append(ch);
                dfs(sb, n, left + 1, right, ans, counts + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /**
     * practice
     * */
    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        dfs1(ans, 0, 0, new StringBuilder(), n);
        return ans;
    }

    private void dfs1(List<String> ans, int left, int right, StringBuilder sb, int n) {
        if (sb.length() == 2 * n){
            if (left == right){
                ans.add(sb.toString());
            }
            return;
        }
        if (left < right){
            return;
        }
        for (char ch : charArray){
            if ('(' == ch){
                sb.append('(');
                dfs1(ans, left + 1, right, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }else{
                if (left > right){
                    sb.append(')');
                    dfs1(ans, left, right + 1, sb, n);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
