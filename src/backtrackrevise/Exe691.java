package backtrackrevise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-01 14:14
 */
public class Exe691 {

    private static final int CHAR_COUNT_BOUND = 26;
    public int minStickers(String[] stickers, String target)
    {
        int m = stickers.length, n = target.length();
        int[] dp = new int[1 << n];
        int[][] cnt = new int[m][26];
        List<LinkedList<Integer>> stickerCharNum = new ArrayList<>();

        for (int i = 0; i < CHAR_COUNT_BOUND; i++)
        {
            stickerCharNum.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < m; i++)
        {
            for (char letter : stickers[i].toCharArray())
            {
                int index = letter - 'a';
                cnt[i][index]++;
                if (stickerCharNum.get(index).isEmpty() || stickerCharNum.get(index).getLast() != i)
                {
                    stickerCharNum.get(index).add(i);
                }
            }
        }

        dp[0] = 0;

        //遍历每一个状态
        for (int i = 0; i < (1<<n) - 1; i++)
        {
            if (dp[i] == Integer.MAX_VALUE)
            {
                continue;
            }
            //找到target 第一个没分配的字母
            int index = 0;
            for (int j = 0; j < n; j++)
            {
                if ((i & (1<<j) )== 0)
                {
                    index = j;
                    break;
                }
            }
            // 字母索引转为 ASCII码值
            index = target.charAt(index) - 'a';

            //对每一个包含该字母的 ticker
            for (int k : stickerCharNum.get(index))
            {
                int next = i;
                int[] left = cnt[k].clone();
                for (int j = 0; j < n; j++)
                {
                    if ((next & (1<<j)) != 0)
                    {
                        continue;
                    }
                    if (left[target.charAt(j) - 'a'] > 0)
                    {
                        left[target.charAt(j) - 'a']--;
                        next |= (1<<j);
                    }
                }
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }
        return dp[(1<<n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1<<n) - 1];
    }
}
