package tree.day26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 11:22
 */
public class exercise1104 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int depth = (int)(Math.log(label)/Math.log(2));
        while (label > 1)
        {
            ans.add(label);
            label = (int) (3 * Math.pow(2, --depth) - label / 2 - 1);
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}
