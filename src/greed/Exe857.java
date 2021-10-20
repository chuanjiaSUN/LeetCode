package greed;

import javax.print.attribute.standard.MediaSize;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-20 14:53
 */
public class Exe857 {
    /**超时*/
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double ans = 1e9;

        for (int captaion = 0; captaion < n; captaion++)
        {
            double factor = (double)wage[captaion] / quality[captaion];
            double prices[] = new double[n];
            int t = 0;
            for (int worker = 0; worker < n; worker++)
            {
                double price = factor * quality[worker];
                if (price < wage[worker]){
                    continue;
                }
                prices[t++] = price;
            }
            if (t < k)
            {
                continue;
            }
            Arrays.sort(prices, 0, t);
            double cand = 0;
            for (int i = 0; i < k; i++)
            {
                cand += prices[i];
            }
            ans = Math.min(ans, cand);
        }
        return ans;
    }

    /**优化*/
    public double mincostToHireWorkers1(int[] quality, int[] wage, int k)
    {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++)
        {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue<>();
        for (Worker worker : workers)
        {
            System.out.println(worker.ratio());
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > k)
            {
                sumq += pool.poll();
            }
            if (pool.size() == k)
            {
                ans = Math.min(ans, sumq * worker.ratio());
            }
        }
        return ans;
    }

    class Worker implements Comparable<Worker>{
        public int quality, wage;
        public Worker(int quality, int wage)
        {
            this.quality = quality;
            this.wage = wage;
        }
        public double ratio()
        {
            return (double)wage/quality;
        }

        @Override
        public int compareTo(Worker o) {
            return Double.compare(ratio(), o.ratio());
        }
    }
}
