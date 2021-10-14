package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-13 10:24
 */
public class InterView {
    public int test(int[] money)
    {
        if (money == null || money.length == 0)
        {
            return 0;
        }
        int n = money.length;
        int[] dp = new int[n];
        dp[0] = money[0];
        int ans = 0;
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i - 1; j++)
            {
                dp[i] = Math.max(dp[i], dp[j] + money[i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        InterView interView = new InterView();
        int test = interView.test(nums);
        System.out.println(test);
    }
}
