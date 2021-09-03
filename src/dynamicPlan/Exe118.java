package dynamicPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-03 9:46
 */
public class Exe118 {
    List<List<Integer>> ans;
    public List<List<Integer>> generate(int numRows) {
        ans = new ArrayList<>();
        if (numRows == 0)
        {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        path.add(1);
        ans.add(path);
        for (int i = 1; i < numRows; i++)
        {
            List<Integer> pre = ans.get(ans.size() - 1);
            int size = pre.size();
            List<Integer> cur = new ArrayList<>();
            cur.add(pre.get(0));
            for (int j = 1; j < size + 1; j++)
            {
                if (j < size){
                    cur.add(pre.get(j) + pre.get(j - 1));
                }else{
                    cur.add(pre.get(j - 1));
                }
            }
            ans.add(cur);
        }
        return ans;
    }
}
