package backTracking;

import sun.print.BackgroundLookupListener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-05 21:56
 */
public class Exercise1593 {
    Set<String> ans;
    int res;
    public int maxUniqueSplit(String s) {
        ans = new HashSet<>();
        backTrack(s, 0, 0);
        return res;
    }

    private void backTrack(String s, int index, int split) {
        if (index >= s.length())
        {
            res = Math.max(res, split);
        }else{
            for (int i = index; i < s.length(); i++)
            {
                String str = s.substring(index, i + 1);
                if (ans.add(str))
                {
                    backTrack(s, i + 1, split + 1);
                    ans.remove(str);
                }
            }
        }
    }

    /**法2*/
    Set<String> set;
    int count;
    public int maxUniqueSplit1(String s)
    {
        set = new HashSet<>();
        backtracking(s, 0);
        return count;
    }

    private void backtracking(String s, int index) {
        if (index == s.length())
        {
            count = Math.max(count, set.size());
            return;
        }
        for (int i = index; i < s.length(); i++)
        {
            String str = s.substring(index, i + 1);
            if (!set.contains(str))
            {
                set.add(str);
                backtracking(s, i + 1);
                set.remove(str);
            }
        }
    }
}
