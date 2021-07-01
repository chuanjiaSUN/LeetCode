package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-01 13:29
 */
public class Exercise691 {
    private static final int CHAR_COUNT = 26;
    /**状态压缩 ： 用二进制数表示动态规划转移过程的状态。*/
    public int minStickers(String[] stickers, String target) {
        int m = stickers.length, n = target.length();

        //二进制状态 dp
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[][] cnt = new int[m][26];

        //存储包含每个字母的stickers下标
        List<LinkedList<Integer>> stickerWithChar = new ArrayList<LinkedList<Integer>>(26);
        for (int i = 0; i < CHAR_COUNT; i++)
        {
            stickerWithChar.add(new LinkedList<>());
        }

        //计算每个sticker字母个数
        for (int i = 0; i < m; i++)
        {
            for (char letter : stickers[i].toCharArray())
            {
                int index = letter - 'a';
                cnt[i][index]++;
                if (stickerWithChar.get(index).isEmpty() || stickerWithChar.get(index).getLast() != i)
                {
                    stickerWithChar.get(index).add(i);
                }
            }
        }

        dp[0] = 0;
        for (int i = 0; i < (1<<n) - 1; i++)
        {
            if (dp[i] == Integer.MAX_VALUE)
            {
                continue;
            }
            int index = 0;
            //找到第一个还未拼凑的字母， 此处是为了优化， 避免因为先后选择顺序导致重复计算
            for (int j = 0; j < n; j++)
            {
                if ((i&(1<<j)) == 0)
                {
                    index = j;
                    break;
                }
            }
            index = target.charAt(index) - 'a';

            //遍历包含该字母的 ticker
            for (int k : stickerWithChar.get(index))
            {
                int next = i;
                //获取sticker包含的字母
                int[] left = cnt[k].clone();
                for (int j = 0; j < n; j++)
                {
                    if ((next & (1<<j)) != 0)
                    {
                        //如果该字母已经有了，continue
                        continue;
                    }
                    if (left[target.charAt(j) - 'a'] > 0)
                    {
                        left[target.charAt(j) - 'a']--;
                        next |= (1 << j);
                    }
                }
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }
        return dp[(1<<n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1<<n) - 1];
    }
}
