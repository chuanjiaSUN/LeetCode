package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-24 12:46
 */
public class Exe718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = m - 1; j >= 0; j--)
            {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    /**滑动窗口*/
    public int findLength1(int[] nums1, int[] nums2)
    {
        int n = nums1.length, m = nums2.length;
        int ret = 0;
        for (int i = 0; i < n; i++)
        {
            int len = Math.min(m, n - i);
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            ret = Math.max(ret, maxLen);
        }
        for (int i = 0; i < m; i++)
        {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(nums1, nums2, 0, i, len);
            ret = Math.max(ret, maxLen);
        }
        return ret;
    }

    private int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++)
        {
            if (A[addA + i] == B[addB + i])
            {
                k++;
            }else{
                k=0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

}
