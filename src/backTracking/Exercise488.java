package backTracking;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-29 13:20
 */
public class Exercise488 {
    private int result = Integer.MAX_VALUE;

    private int[] map = new int[26];

    private char[] colors = {'R', 'Y', 'B', 'G', 'W'};

    public int findMinStep(String board, String hand)
    {
        for (int i = 0; i < hand.length(); i++)
        {
            map[hand.charAt(i) - 'A']++;
        }
        dfs(new StringBuilder(board), 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(StringBuilder board, int step) {
        if (step >= result)
        {
            return;
        }
        if (board.length() == 0)
        {
            result = Math.min(result, step);
            return;
        }
        for (int i = 0; i < board.length(); i++)
        {
            char c = board.charAt(i);
            int j = i;
            while (j + 1 < board.length() && board.charAt(j + 1) == c)
            {
                j++;
            }

            //只有单个球
            if (j == i && map[c - 'A'] >= 2)
            {
                StringBuilder temp = new StringBuilder(board);
                temp.insert(i, c + "" + c);
                map[c - 'A'] -= 2;
                dfs(eliminate(temp), step + 2);
                map[c - 'A'] += 2;
            }else if ( j == i + 1)
            {
                //存在两个颜色相同且相邻的球
                if (map[c - 'A'] >= 1)
                {
                    StringBuilder temp = new StringBuilder(board);
                    temp.insert(i, c);
                    map[c - 'A']--;
                    dfs(eliminate(temp), step + 1);
                    map[c - 'A']++;
                }


                for (char color : colors)
                {
                    if (color == c)
                    {
                        continue;
                    }
                    if (map[color - 'A'] >= 1)
                    {
                        StringBuilder temp = new StringBuilder(board);
                        //往两个颜色相同的球中间插入一个颜色不同的球
                        temp.insert(i + 1, color);
                        map[color - 'A']--;
                        dfs(eliminate(temp), step + 1);
                        map[color - 'A']++;
                    }
                }
            }
        }
    }

    private StringBuilder eliminate(StringBuilder sb) {
        boolean flag = true;
        while (flag)
        {
            flag = false;
            for (int i = 0; i < sb.length(); i++)
            {
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i))
                {
                    j++;
                }
                if (j - i >= 3)
                {
                    sb.delete(i, j);
                    flag = true;
                }
            }
        }
        return sb;
    }
}
