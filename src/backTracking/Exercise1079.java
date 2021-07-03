package backTracking;


import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-03 20:57
 */
public class Exercise1079 {
    int ans = 0;
    boolean[] visited;
    public int numTilePossibilities(String tiles) {
        char[] charArray = tiles.toCharArray();
        Arrays.sort(charArray);
        visited = new boolean[charArray.length];
        backTrack(charArray, 0);
        return ans;

    }

    private void backTrack(char[] charArray, int index) {
        if (index == charArray.length)
        {
            return;
        }
        for (int i = 0; i < charArray.length; i++)
        {
            if (!visited[i])
            {
                if ( i > 0 && charArray[i] == charArray[i - 1] && !visited[i - 1])
                {
                    continue;
                }
                visited[i] = true;
                ans++;
                backTrack(charArray, index + 1);
                visited[i] = false;
            }
        }
    }

    /**法2 */
    private static final int CHAR_NUM = 26;
    public int numTilePossibilities1(String tiles)
    {
        char[] chars = tiles.toCharArray();
        int[] count = new int[26];
        for (char c : chars)
        {
            count[c - 'A']++;
        }
        backTrack1(chars, count);
        return ans;
    }

    private void backTrack1(char[] chars, int[] count) {
        for (int i = 0; i < CHAR_NUM; i++)
        {
            if (count[i] == 0)
            {
                continue;
            }
            count[i]--;
            ans++;
            backTrack1(chars, count);
            count[i]++;
        }
    }
}
