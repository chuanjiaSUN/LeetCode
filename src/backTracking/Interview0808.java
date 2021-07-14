package backTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-14 20:20
 */
public class Interview0808 {
    List<String> res;
    StringBuilder sb;
    boolean[] used;
    public String[] permutation(String S) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        used = new boolean[S.length()];
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        backTrack(0, chars);
        return res.toArray(new String[res.size()]);

//        int size = res.size();
//        String[] ans = new String[size];
//        int i = 0;
//        for (String str : res)
//        {
//            ans[i++] = str;
//        }
//        return ans;

    }

    private void backTrack(int index, char[] charArray) {
        if (sb.length() == charArray.length)
        {
            res.add(sb.toString());
            return;
        }
        if (index >= charArray.length)
        {
            return;
        }
        for (int i = 0; i < charArray.length; i++)
        {
            if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1])
            {
                continue;
            }
            if (!used[i])
            {
                used[i] = true;
                sb.append(charArray[i]);
                backTrack(index, charArray);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
