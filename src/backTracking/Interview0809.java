package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-14 20:45
 */
public class Interview0809 {
    char[] symbols = new char[]{'(', ')'};
    List<String> ans;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        sb = new StringBuilder();
        backTrack(n, 0, 0, 0);
        return ans;
    }

    private void backTrack(int n, int left, int right, int count) {
        if (left < right)
        {
            return;
        }
        if (left == n && right == n)
        {
            ans.add(sb.toString());
            return;
        }
        for (char symbol : symbols)
        {
            if (count < n * 2)
            {
                if (symbol == '(')
                {
                    sb.append('(');
                    backTrack(n, left + 1, right, count + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }else if (symbol == ')')
                {
                    sb.append(')');
                    backTrack(n, left, right + 1, count + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }

        }
    }
}
