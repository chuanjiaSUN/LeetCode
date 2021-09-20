package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-19 10:52
 */
public class Exe553 {
    /**DFS*/
    class T{
        float maxVal, minVal;
        String minStr,maxStr;
    }
    public String optimalDivision(int[] nums) {
        T[][] memo = new T[nums.length][nums.length];
        T t = optimal(nums, 0, nums.length - 1, "", memo);
        return t.maxStr;
    }

    private T optimal(int[] nums, int start, int end, String res, T[][] memo) {
        if (memo[start][end] != null)
        {
            return memo[start][end];
        }
        T t = new T();
        if (start == end)
        {
            t.maxVal = nums[start];
            t.minVal = nums[start];
            t.minStr = "" + nums[start];
            t.maxStr = "" + nums[start];
            memo[start][end] = t;
            return t;
        }
        t.minVal = Float.MAX_VALUE;
        t.maxVal = Float.MIN_VALUE;
        t.minStr = t.maxVal + "";
        for (int i = start; i < end; i++)
        {
            T left = optimal(nums, start, i, "", memo);
            T right = optimal(nums, i+ 1, end, "", memo);
            if (t.minVal > left.minVal / right.maxVal)
            {
                t.minVal = left.minVal/right.maxVal;
                t.minStr = left.minStr + "/" + (i + 1 != end ? "(" : "") + right.maxStr + (i + 1 != end ? ")" : "");
            }
            if (t.maxVal < left.maxVal / right.minVal)
            {
                t.maxVal = left.maxVal / right.minVal;
                t.maxStr = left.maxStr + "/" + (i + 1 != end ? "(" : "") + right.minStr + (i + 1 != end ? ")":"");
            }
        }
        memo[start][end] = t;
        return t;
    }
    /**动规*/
    public String optimalDivision1(int[] nums) {
        int n = nums.length;
        double[][][] dp = new double[n][n][2];
        String[][][] strs = new String[n][n][2];
        for (int i = 0; i < n; i++)
        {
            dp[i][i][0] = nums[i];
            dp[i][i][1] = nums[i];
            strs[i][i][0] = ""+nums[i];
            strs[i][i][1] = ""+nums[i];
        }
        for (int l = 2; l <= n; l++)
        {
            for (int i = 0; i + l - 1 <n; i++)
            {
                int j = i + l - 1;
                double max = Double.MIN_VALUE;
                double min = Double.MAX_VALUE;
                StringBuilder a = new StringBuilder(), b = new StringBuilder();
                for (int k = i; k < j; k++)
                {
                    if (dp[i][k][0] / dp[k + 1][j][1] > max)
                    {
                        max = dp[i][k][0] / dp[k + 1][j][1];
                        if (k + 1 == j)
                        {
                            a.append(strs[i][k][0]).append("/").append(strs[k + 1][j][1]);
                        }else{
                            a.append(strs[i][k][0]).append("/(").append(strs[k + 1][j][1]).append(")");
                        }
                    }
                    if (dp[i][k][1] / dp[k + 1][j][0] < min)
                    {
                        min = dp[i][k][1] / dp[k + 1][j][0];
                        if (k + 1 == j)
                        {
                            b.append(strs[i][k][1]).append("/").append(strs[k + 1][j][0]);
                        }else{
                            b.append(strs[i][k][1]).append("/(").append(strs[k + 1][j][0]).append(")");
                        }
                    }
                }
                dp[i][j][0] = max;
                dp[i][j][1] = min;
                strs[i][j][0] = a.toString();
                strs[i][j][1] = b.toString();
            }
        }
        return strs[0][n - 1][0];
    }
}
