package greed;


import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-20 14:08
 */
public class Exe826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        int ans = 0;
        for (int i = 0; i < m; i++)
        {
            int possible = worker[i];
            int maxProfit = 0;
            for (int j = 0 ; j < n; j++)
            {
                if (difficulty[j] <= possible)
                {
                    maxProfit = Math.max(maxProfit, profit[j]);
                }
            }
            if (maxProfit != 0)
            {
                ans += maxProfit;
            }
        }
        return ans;
    }
    /**法2*/
    public int maxProfitAssignment1(int[] difficulty, int[] profit, int[] worker)
    {
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++)
        {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a.d, b.d));
        int[] dp = new int[n];
        dp[0] = jobs[0].p;
        for (int i = 1; i < n; i++)
        {
            dp[i] = Math.max(dp[i - 1], jobs[i].p);
        }
        int res = 0;
        for(int w : worker)
        {
            int index = binarySearch(jobs, w);
            if (index >= 0) {
                res += dp[index];
            }
        }
        return res;
    }

    private int binarySearch(Job[] jobs, int w) {
        int left = 0, right = jobs.length - 1;
        while (left <= right)
        {
            int mid = left + ((right - left) >> 1);
            if (jobs[mid].d <= w)
            {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private static class Job{
        public int d;
        public int p;
        public Job(int d, int p)
        {
            this.d = d;
            this.p = p;
        }
    }

}
