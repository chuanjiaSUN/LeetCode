package backTracking;

import java.lang.invoke.VolatileCallSite;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-26 10:50
 */
public class Exercise306 {
    static final int LOW_COUNT = 3;
    int n;
    String str;
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < LOW_COUNT)
        {
            return false;
        }
        n = len;
        str = num;
        return backTrack(0, 0, 0, 0);
    }

    /**
     * backTrack
     * @param index 当前下标
     * @param sum 前两个数和
     * @param prev 前一个数
     * @param count 已生成几个数
     * */
    private boolean backTrack(int index, long sum, long prev, int count) {
        if (index == n)
        {
            return count >= 3;
        }
        for (int i = index; i < n; i++)
        {
            long cur = fetchCurValue(str, index, i);
            if (cur < 0)
            {
                continue;
            }
            if (count >= 2 && cur != sum)
            {
                continue;
            }
            if (backTrack(i + 1, prev + cur, cur, count + 1))
            {
                return true;
            }
        }
        return false;
    }

    private long fetchCurValue(String str, int index, int i) {
        if (index < i && str.charAt(index) == '0')
        {
            return -1;
        }
        long ans = 0;
        while (index <= i)
        {
            ans = ans * 10 + str.charAt(index++) - '0';
        }
        return ans;
    }
}
