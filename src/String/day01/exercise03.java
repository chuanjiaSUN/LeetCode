package String.day01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-19 15:03
 */
public class exercise03 {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int length = s.length();
        //初始化右指针 right
        int right = -1, ans = 0;
        for (int i = 0; i < length; i++)
        {
            if ( i != 0)
            {
                //左指针向右移动一格， 移除一个字符
                set.remove(s.charAt( i - 1));
            }
            while ( right + 1 < length && !set.contains( s.charAt( right + 1)))
            {
                set.add(s.charAt( right + 1));
                right++;
            }
            ans = Math.max( ans, right - i + 1);
        }
        return ans;
    }
}
