package dynamicPlan;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-17 10:33
 */
public class Exe485 {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        return dfs(nums, 0, len - 1, 1) >= 0;
    }

    private int dfs(int[] nums, int start, int end, int turn) {
        if (start == end)
        {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + dfs(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + dfs(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }

    /**动规*/
    public boolean PredictTheWinner1(int[] nums)
    {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++)
        {
            dp[i][i] = nums[i];
        }
        for (int i = len - 2; i >= 0; i++)
        {
            for (int j = i + 1; j < len; i++)
            {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }

    /**动规，从左往右遍历*/
    public boolean PredictTheWinner2(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++)
        {
            dp[i][i] = nums[i];
        }
        for(int j = 1; j < len; j++)
        {
            for(int i = j - 1; i >= 0; i--)
            {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }
}
