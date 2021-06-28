package backTracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-28 13:09
 */
public class Exercise301 {
    int len;
    char[] charArray;
    Set<String> validExpressions;
    public List<String> removeInvalidParentheses(String s) {
        validExpressions = new HashSet<>();
        this.len = s.length();
        this.charArray = s.toCharArray();

        //1.计算多余左右括号
        int leftRemove = 0;
        int rightRemove = 0;
        for (int i = 0; i < len; i++)
        {
            if (charArray[i] == '(')
            {
                leftRemove++;
            }else if (charArray[i] == ')')
            {
                if (leftRemove == 0)
                {
                    rightRemove++;
                }
                if (leftRemove > 0)
                {
                    leftRemove--;
                }
            }
        }

        StringBuilder path = new StringBuilder();
        backTrack(0, 0, 0, leftRemove, rightRemove, path);
        return new ArrayList<>(this.validExpressions);
    }

    private void backTrack(int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder path) {
        if (index == len)
        {
            if (leftRemove == 0 && rightRemove == 0)
            {
                validExpressions.add(path.toString());
            }
            return;
        }

        char symbol = charArray[index];
        if (symbol == '(' && leftRemove > 0)
        {
            //尝试删除左括号
            backTrack(index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, path);
        }
        if (symbol == ')' && rightRemove > 0)
        {
            //尝试删除右括号
            backTrack(index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, path);
        }

        //保留当前字符
        path.append(symbol);
        if (symbol != '(' && symbol != ')')
        {
            backTrack(index + 1, leftCount, rightCount, leftRemove, rightRemove, path);
        }else if (symbol == '('){
            backTrack(index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, path);
        }else if (rightCount < leftCount)
        {
            //只有当左括号严格大于右括号数量时，才能继续添加右括号
            backTrack(index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, path);
        }
        path.deleteCharAt(path.length() - 1);
    }
}
