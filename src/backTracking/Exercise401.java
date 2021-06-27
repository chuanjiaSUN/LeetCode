package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-27 13:42
 */
public class Exercise401 {
    static final int HOURS = 12;
    static final int MINUTES = 60;
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int h = 0; h < HOURS; h++)
        {
            for (int m = 0; m < MINUTES; m++)
            {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                {
                    ans.add(h + ":" + (m < 10 ? "0":"")+m);
                }

            }
        }
        return ans;
    }

    public List<String> readBinaryWatch1(int turnedOn)
    {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < (1 << 10); i++)
        {
            int h = i >> 6, m = i & 63;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn)
            {
                ans.add(h + ":" + (m < 10 ? "0":"") + m);
            }
        }
        return ans;
    }

}
