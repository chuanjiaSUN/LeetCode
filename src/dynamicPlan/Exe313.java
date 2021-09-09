package dynamicPlan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-09 10:34
 */
public class Exe313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++)
        {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++)
            {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j <m; j++)
            {
                if (minNum == nums[j])
                {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
    /**最小堆*/
    public int nthSuperUglyNumber1(int n, int[] primes)
    {
        Set<Long> seen = new HashSet<>();
        seen.add(1L);
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++)
        {
            long curr = heap.poll();
            ugly = (int)curr;
            for (int prime : primes)
            {
                long next = curr * prime;
                if (seen.add(next))
                {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
