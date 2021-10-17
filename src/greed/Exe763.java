package greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-17 13:28
 */
public class Exe763 {
    public List<Integer> partitionLabels(String s) {
        int[] pos = new int[26];
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++)
        {
            pos[arr[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++)
        {
            end = Math.max(end, pos[arr[i] - 'a']);
            if (i == end)
            {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
