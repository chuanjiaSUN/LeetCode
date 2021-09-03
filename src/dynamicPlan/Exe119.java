package dynamicPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-03 9:56
 */
public class Exe119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0)
        {
            return ans;
        }
        for (int i = 1; i <= rowIndex; i++)
        {
            int size = ans.size();
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j <= size; j++)
            {
                if (j < size)
                {
                    temp.add(ans.get(j) + ans.get(j - 1));
                }else{
                    temp.add(ans.get(j - 1));
                }
            }
            ans = temp;
        }
        return ans;
    }
}
