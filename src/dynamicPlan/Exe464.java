package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-16 12:06
 */
public class Exe464 {
    boolean[] visited;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
        {
            return true;
        }
        if ( ((maxChoosableInteger + 1) * maxChoosableInteger) / 2 < desiredTotal)
        {
            return false;
        }
        visited = new boolean[maxChoosableInteger + 1];
        return dfs(maxChoosableInteger, desiredTotal, 1, 0);
    }

    private boolean dfs(int maxChoosableInteger, int desiredTotal, int curIndex, int curSum) {
        if (desiredTotal <= 0)
        {
            return false;
        }
        for (int i = 1; i <= maxChoosableInteger; i++)
        {
            if (!visited[i])
            {
                visited[i] = true;
                boolean dfs = dfs(maxChoosableInteger, desiredTotal - i, curIndex, curSum);
                visited[i] = false;
                if (!dfs)
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**状态压缩*/
    public boolean canIWin1(int maxChoosableInteger, int desiredTotal)
    {
        if (maxChoosableInteger >= desiredTotal)
        {
            return true;
        }
        if ( (( 1 + maxChoosableInteger) * maxChoosableInteger) / 2 < desiredTotal)
        {
            return false;
        }
        Boolean[] dp = new Boolean[(1 << maxChoosableInteger )- 1];
        return dfs1(maxChoosableInteger, desiredTotal, 0, dp);
    }

    private boolean dfs1(int maxChoosableInteger, int desiredTotal, int state, Boolean[] dp) {
        if (dp[state] != null)
        {
            return dp[state];
        }
        for (int i = 1; i <= maxChoosableInteger; i++)
        {
            int tmp = (1 << i - 1);
            if ((tmp & state) == 0)
            {
                if (desiredTotal - i <= 0 || !dfs1(maxChoosableInteger, desiredTotal - i, tmp | state, dp))
                {
                    dp[state] = true;
                    return true;
                }
            }
        }
        dp[state] = false;
        return false;
    }
}
