package String.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-27 9:36
 */
public class ReCall_exercise93 {
    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT]; //用来记录每一段ip
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        //如果找到了4段ID，并遍历完，就是一种答案
        if (segId == SEG_COUNT)
        {
            if (segStart == s.length())
            {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; i++)
                {
                    ipAddr.append(segments[i]);
                    if ( i != SEG_COUNT - 1)
                    {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        //如果没有找到,并且遍历完字符串，提前回溯
        if (segStart == s.length())
        {
            return;
        }
        //不能有前导的0,若当前为0，该段IP为0
        if (s.charAt(segStart) == '0')
        {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        //普通情况, 枚举每一种可能性，递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++)
        {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF)
            {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            }else{
                break;
            }
        }
    }


}
