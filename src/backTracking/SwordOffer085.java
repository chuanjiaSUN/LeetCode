package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-06 23:05
 */
public class SwordOffer085 {
    List<String> ans;
    char[] symbols = {'(', ')'};
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        backTrack(n, new StringBuffer(), 0, 0, 0);
        return ans;
    }

    private void backTrack(int n, StringBuffer sb, int leftCount, int rightCount, int total) {
        if (leftCount < rightCount)
        {
            return;
        }
        if (total == n * 2 && leftCount == n && rightCount == n)
        {
            ans.add(sb.toString());
            return;
        }
        for(char symbol : symbols)
        {
            if (symbol == '(' && leftCount < n)
            {
                sb.append('(');
                backTrack(n, sb, leftCount + 1, rightCount, total + 1);
                sb.deleteCharAt(sb.length() - 1);
            }else if (symbol == ')')
            {
                if (leftCount <= rightCount)
                {
                    continue;
                }
                sb.append(')');
                backTrack(n, sb, leftCount, rightCount + 1, total + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
