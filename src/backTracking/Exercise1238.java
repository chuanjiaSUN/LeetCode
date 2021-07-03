package backTracking;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-03 22:02
 */
public class Exercise1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<Integer>() {};
        res.add(start);
        int lab = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = lab - 1; j >= 0; j--)
            {
                res.add(res.get(j) ^ lab);
            }
            lab <<= 1;
        }
        return res;
    }

    /**法2 生成格雷码 然后截断*/
    public List<Integer> circularPermutation1(int n, int start)
    {
        if (n <= 0 || start < 0 || start >= (int)Math.pow(2, n))
        {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if (n == 1)
        {
            list.add(start);
            list.add(1 - start);
            return list;
        }
        list.add(0);
        list.add(1);
        int index = start == 1 ? 1 : 0;
        for (int i = 2; i <= n; i++)
        {
            int temp = list.size();
            for (int j = temp - 1; j >= 0; j--)
            {
                int value = list.get(j) + (1 << (i - 1));
                list.add(value);
                if (value == start)
                {
                    index = list.size() - 1;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.addAll(list.subList(index, list.size()));
        ans.addAll(list.subList(0, index));
        return ans;

    }
}
