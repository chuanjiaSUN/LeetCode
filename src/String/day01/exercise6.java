package String.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-19 16:29
 */
public class exercise6 {

    // 从左至右迭代字符串， 按行排序
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
        {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray())
        {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1 )
            {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : list)
        {
            ret.append(row);
        }
        return ret.toString();
    }

    //按行访问
    public String convert1(String s, int numRows)
    {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycle = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++)
        {
            for (int j = 0; j + i < n; j+= cycle)
            {
                ret.append( s.charAt( j + i));
                if ( i != 0 && i != numRows - 1 && j + cycle - i < n)
                {
                    ret.append(s.charAt( j + cycle -i));
                }
            }
        }
        return ret.toString();
    }

}
