package dynamicPlan.practice;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 22:45
 */
public class Practice718 {
    public int findLength(int[] nums1, int[] nums2)
    {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = m - 1; j >= 0; j--)
            {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1: 0;
                ans = Math.max(ans , dp[i][j]);
            }
        }
        return ans;
    }
}
