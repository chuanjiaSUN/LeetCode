package backTracking;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-29 11:42
 */
public class Exercise638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < needs.size(); i++)
        {
            res += needs.get(i) * price.get(i);
        }

        for (List<Integer> item : special)
        {
            List<Integer> clone = new ArrayList<>(needs);
           int j;
           for (j = 0; j < needs.size(); j++)
           {
               int diff = clone.get(j) - item.get(j);
               if (diff < 0)
               {
                   break;
               }
               clone.set(j, diff);
           }
           if (j == needs.size())
           {
               res = Math.min(res, item.get(j) + dfs(price, special, clone));
           }
        }
        return res;
    }
}
