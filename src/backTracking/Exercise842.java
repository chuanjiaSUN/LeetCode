package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-01 12:06
 */
public class Exercise842 {
    List<Integer> ans;
    static final int COUNT_BOUND = 3;
    public List<Integer> splitIntoFibonacci(String num) {
        ans = new ArrayList<>();
        backTrack(num.toCharArray(), 0);
        return ans;
    }

    private boolean backTrack(char[] charArray, int index) {
        if (index == charArray.length && ans.size() >= COUNT_BOUND)
        {
            return true;
        }
        for (int i = index; i < charArray.length; i++)
        {
            //2位以上数字不能以0开头
            if (charArray[index] == '0' && i > index)
            {
                break;
            }
            long num = subDigit(charArray, index, i + 1);
            if (num > Integer.MAX_VALUE)
            {
                break;
            }
            int size = ans.size();
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2))
            {
                break;
            }
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2))
            {
                ans.add((int)num);
                if (backTrack(charArray, i + 1))
                {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    private long subDigit(char[] charArray, int index, int end) {
        long res = 0;
        for (int i = index; i < end; i++)
        {
            res = res * 10 + (charArray[i] - '0');
        }
        return res;
    }
}
