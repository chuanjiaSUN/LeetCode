package backTracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-17 17:18
 */
public class Exercise1096 {
    public List<String> braceExpansionII(String expression) {
        return expansion(expression).stream().sorted().collect(Collectors.toList());
    }

    private Set<String> expansion(String expression) {
        Set<String> res = new HashSet<>(50);
        if ("".equals(expression))
        {
            return res;
        }else if (!expression.contains("{"))
        {
            //不含 {}， 直接分割
            return Arrays.stream(expression.split(",")).collect(Collectors.toSet());
        }else
        {
            int pair = 0, pairStart = -1, pairEnd = -1;
            for (int i = 0; i < expression.length(); i++)
            {
                if (expression.charAt(i) == '{')
                {
                    if (pairStart == -1)
                    {
                        pairStart = i;
                    }
                    pair++;
                }else if (expression.charAt(i) == '}')
                {
                    pair--;
                }
                if (pair == 0)
                {
                    //遍历到括号最里面
                    if (pairStart != -1 && pairEnd == -1)
                    {
                        pairEnd = i;
                    }
                    //pair==0，即不在某个{}中间，那么可以将表达式分成两段
                    if (expression.charAt(i) == ',')
                    {
                        res.addAll(expansion(expression.substring(0, i)));
                        res.addAll(expansion(expression.substring(i + 1)));
                        return res;
                    }
                }
            }
            //剩下的只有 {a{b}{c}} a{b}c {}{} 这种形式
            String prefix = "";
            //括号起点不为0， 说明是a{b}c这种形式
            if (pairStart != 0)
            {
                prefix = expression.substring(0, pairStart);
            }
            //剥掉第一个的最外层括号
            Set<String> left = expansion(expression.substring(pairStart + 1, pairEnd));
            //求出第一个完整{}后部分
            Set<String> right = expansion(expression.substring(pairEnd + 1));
            //为了方便计算加入空串
            if (left.isEmpty())
            {
                left.add("");
            }
            if (right.isEmpty())
            {
                right.add("");
            }
            //拼接
            for (String l : left)
            {
                for (String r : right)
                {
                    res.add(prefix + l + r);
                }
            }
        }
        return res;
    }
}
