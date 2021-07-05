package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-05 20:48
 */
public class Exercise1239 {
    int ans = 0;
    public int maxLength(List<String> arr) {
        List<Integer> masks = new ArrayList<>();
        for (String s : arr)
        {
            int mask = 0;
            for (int i = 0; i < s.length(); i++)
            {
                int ch = s.charAt(i) - 'a';
                //若 mask 已有 ch, 则说明 s 含有重复字母， 无法构成可行解
                if (((mask >> ch) & 1) != 0)
                {
                    mask = 0;
                    break;
                }
                // ch 加入 mask
                mask |= 1 << ch;
            }
            if (mask > 0)
            {
                masks.add(mask);
            }
        }
        backTrack(masks, 0, 0);
        return ans;
    }

    private void backTrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size())
        {
            //取 2 进制 1 的个数
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        // mask 与 masks[pos] 无公共元素
        if ((mask & masks.get(pos)) == 0)
        {
            backTrack(masks, pos + 1, mask | masks.get(pos));
        }
        backTrack(masks, pos + 1, mask);
    }
}
