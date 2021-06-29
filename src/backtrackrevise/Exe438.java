package backtrackrevise;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-29 14:05
 */
public class Exe438 {
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
            result = step;
            return;
        }
        for (int i = 0; i < board.length(); i++)
        {
            char c = board.charAt(i);
            int j = i;
            while (j + 1< board.length() && board.charAt(j + 1) == c)
            {
                j++;
            }

            if (j == i && map[c - 'A'] >= 2)
            {
                StringBuilder temp = new StringBuilder(board);
                temp.insert(i, c + "" + c);
                map[c - 'A'] -= 2;
                dfs(eliminate(temp), step + 2);
                map[c - 'A'] += 2;
            }else if (j == i + 1)
            {
                if (map[c - 'A'] >= 1)
                {
                    //往两个颜色相同的地方放同色求
                    StringBuilder temp = new StringBuilder(board);
                    temp.insert(i, c);
                    map[c - 'A']--;
                    dfs(eliminate(temp), step + 1);
                    map[c - 'A']++;
                }
                //往两个颜色相同中间放不同颜色的球
                for (char color : colors)
                {
                    if (color == c)
                    {
                        continue;
                    }
                    if (map[color - 'A'] >= 1)
                    {
                        StringBuilder temp = new StringBuilder(board);
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
