package String.day15;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-12 11:29
 */
public class exercise522 {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++)
        {
            for ( j = 0; j < strs.length; j++)
            {
                if ( i == j) continue;
                if (isSubsequence(strs[i], strs[j])) break;
            }
            if (j == strs.length)
                res = Math.max(strs[i].length(), res);
        }
        return res;
    }

    private boolean isSubsequence(String str, String str1) {
        int j = 0;
        for (int i = 0; i < str1.length() && j < str.length(); i++)
        {
            if (str.charAt(j) == str1.charAt(i)) j++;
        }
        return j == str.length();
    }

    // 排序后比较更快
    public int findLUSlength1(String[] strs)
    {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        for (int i = 0, j; i < strs.length; i++)
        {
            boolean flag = true;
            for (j = 0; j < strs.length; j++)
            {
                if (i==j) continue;
                if (isSubsequence(strs[i], strs[j])){
                    flag = false;
                    break;
                }
            }
            if (flag) return strs[i].length();
        }
        return -1;
    }
}
