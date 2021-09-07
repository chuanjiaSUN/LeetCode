package dynamicPlan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-07 11:30
 */
public class Exe241 {
    /**法1 递归*/
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        int length = expression.length();
        if (length == 0)
        {
            return ans;
        }
        //全数字
        int num = 0;
        int index = 0;
        while (index < length && !isOperation(expression.charAt(index)))
        {
            num = num * 10 + (expression.charAt(index) - '0');
            index++;
        }
        if (index == length)
        {
            ans.add(num);
            return ans;
        }
        //带符号
        for (int i = 0; i < length; i++)
        {
            if (isOperation(expression.charAt(i)))
            {
                List<Integer> leftRes = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(expression.substring(i + 1));
                for (int j = 0; j < leftRes.size(); j++)
                {
                    for (int k = 0; k < rightRes.size(); k++)
                    {
                        char op = expression.charAt(i);
                        ans.add(caculate(leftRes.get(j), rightRes.get(k), op));
                    }
                }
            }
        }
        return ans;
    }

    private Integer caculate(Integer l, Integer r, char op) {
        switch (op)
        {
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '*':
                return l * r;
            default:
                return -1;
        }
    }

    private boolean isOperation(char charAt) {
        return charAt == '+' || charAt == '-' || charAt == '*';
    }

    Map<String, List<Integer>> map = new HashMap<>();
    /**记忆化搜索*/
    public List<Integer> diffWaysToCompute1(String expression)
    {
        if (expression == null)
        {
            return new ArrayList<>();
        }
        int length = expression.length();
        if (length == 0){
            return new ArrayList<>();
        }
        if (map.containsKey(expression))
        {
            return map.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        int num = 0;
        int index = 0;
        while (index < length && !isOperation(expression.charAt(index)))
        {
            num = num * 10 + (expression.charAt(index) - '0');
            index++;
        }
        if (index == length)
        {
            res.add(num);
            map.put(expression, res);
            return res;
        }
        for (int i = 0; i < length; i++)
        {
            if (isOperation(expression.charAt(i)))
            {
                List<Integer> left = diffWaysToCompute1(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute1(expression.substring(i + 1));
                for (int j = 0; j < left.size(); j++)
                {
                    for (int k = 0; k < right.size(); k++)
                    {
                        char op = expression.charAt(i);
                        res.add(caculate(left.get(j), right.get(k), op));
                    }
                }
            }
        }
        map.put(expression, res);
        return res;
    }

}
