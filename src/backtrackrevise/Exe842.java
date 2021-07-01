package backtrackrevise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-01 15:32
 */
public class Exe842 {
    List<Integer> ans;
    private static final int LIST_COUNT = 3;
    public List<Integer> splitIntoFibonacci(String num)
    {
        ans = new ArrayList<>();
        backTrack(num.toCharArray(), 0);
        return ans;
    }

    private boolean backTrack(char[] nums, int start) {
        if (start == nums.length && ans.size() >= LIST_COUNT)
        {
            return true;
        }
        for (int i = start; i < nums.length; i++)
        {
            if (nums[i] == '0' && i > start)
            {
                break;
            }
            long num = getDigit(nums, start, i + 1);
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
                if (backTrack(nums, i + 1)){
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }

        return false;
    }

    private long getDigit(char[] nums, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++)
        {
            res = res * 10 + (nums[i] - '0');
        }
        return res;
    }
}
