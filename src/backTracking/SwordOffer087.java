package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-06 23:15
 */
public class SwordOffer087 {
    private static final int SET_COUNT = 4;
    List<String> ans;
    int[] segments = new int[SET_COUNT];
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        backTrack(s, 0, 0);
        return ans;
    }

    private void backTrack(String s, int segId, int segStart) {
        if (segId == SET_COUNT)
        {
            if (segStart == s.length())
            {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < SET_COUNT; i++)
                {
                    sb.append(segments[i]);
                    if (i != SET_COUNT - 1)
                    {
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }

        if (segStart == s.length())
        {
            return;
        }
        if (s.charAt(segStart) == '0')
        {
            segments[segId] = 0;
            backTrack(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++)
        {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr >0 && addr <= 0xFF)
            {
                segments[segId] = addr;
                backTrack(s, segId + 1, segEnd + 1);
            }else{
                break;
            }
        }
    }

}
