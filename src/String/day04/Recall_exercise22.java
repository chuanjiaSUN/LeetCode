package String.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.UnknownFormatConversionException;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-22 10:11
 */
public class Recall_exercise22 {
    // 暴力法， 递归求出每种组合，并检验
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(new char[ 2 * n], 0, ans);
        return ans;
    }

    private void dfs(char[] combination, int pos, List<String> result) {
        if (pos == combination.length)
        {
            if (isValid(combination))
            {
                result.add(new String(combination));
            }
        }else{
            combination[pos] = '(';
            dfs(combination, pos + 1, result);
            combination[pos] = ')';
            dfs(combination, pos + 1, result);
        }
    }

    private boolean isValid(char[] combination) {
        int balance = 0;
        for (Character c : combination)
        {
            if ( c == '(')
            {
                balance++;
            }else{
                balance--;
            }
            if (balance < 0) return false;
        }
        return true;
    }

    //法2 回溯 在dfs路径有效前提下添加新的组合元素
    public List<String> generateParenthesis1(int n)
    {
        List<String> ans = new ArrayList<>();
        backTrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    //回溯遍历
    private void backTrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2)
        {
            ans.add(cur.toString());
            return;
        }
        //如果左括号数量不大于n，可以放1个左括号
        if (open < max)
        {
            cur.append('(');
            backTrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        //如果右括号小于左括号，可以放一个右括号
        if (close < open)
        {
            cur.append(')');
            backTrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    //法3 按照括号序列的长度递归
    ArrayList[] cache = new ArrayList[100];
    public List<String> generateParenthesis2(int n)
    {
        if ( cache[n] != null)
        {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0)
        {
            ans.add("");
        }else
        {
            for (int i = 0; i < n; i++)
            {
                for (String left : generateParenthesis2(i))
                {
                    for (String right:generateParenthesis2( n - i - 1))
                    {
                        ans.add("("+left+")"+ right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
}
