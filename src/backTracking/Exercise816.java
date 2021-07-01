package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-30 13:24
 */
public class Exercise816 {
    List<String> ans;
    /**表示是否使用了 ', ' , '.' */
    public List<String> ambiguousCoordinates(String s) {
        ans = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++)
        {
            for (String left : make(s, 1, i))
            {
                for (String right : make(s, i, s.length() - 1))
                {
                    ans.add("(" + left + ", " + right + ")");
                }
            }
        }
        return ans;
    }

    private List<String> make(String s, int i, int j) {
        // Make on S.substring(i, j)
        List<String> ans = new ArrayList<>();
        for (int d = 1; d <= j-i; ++d) {
            String left = s.substring(i, i+d);
            String right = s.substring(i+d, j);
            String addStr = left + (d < j - i ? "." : "") + right;
            if ((!left.startsWith("0") || "0".equals(left)) && ! right.endsWith("0"))
            {
                ans.add(addStr);
            }
        }
        return ans;
    }
}
