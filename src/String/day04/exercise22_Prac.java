package String.day04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-22 10:44
 */
public class exercise22_Prac {
    //回溯
    public List<String> generateParenthesis(int n)
    {
        List<String> ans = new ArrayList<>();
        dfsRecall(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void dfsRecall(List<String> ans, StringBuilder combination, int left, int right, int max) {
        if (combination.length() == 2 * max)
        {
            ans.add(combination.toString());
            return;
        }
        //左括号小于n
        if (left < max)
        {
            combination.append('(');
            dfsRecall(ans, combination, left + 1, right, max);
            combination.deleteCharAt( combination.length() - 1);
        }
        //右括号小于左括号
        if (right < left)
        {
            combination.append(')');
            dfsRecall(ans, combination, left, right + 1, max);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        exercise22_Prac e = new exercise22_Prac();
        List<String> strings = e.generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
