package dynamicPlan;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-25 21:34
 */
public class Exe763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++)
        {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> path = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++)
        {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (end == i)
            {
                path.add(end - start + 1);
                start = end + 1;
            }
        }
        return path;
    }
}
