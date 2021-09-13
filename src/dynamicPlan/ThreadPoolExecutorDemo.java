package dynamicPlan;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 16:02
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        for (int i = 0; i < 10; i++)
        {
            Runnable work = new MyRunnable("测试 ： " + i);
            executor.execute(work);
        }
        executor.shutdown();
        while (!executor.isTerminated())
        {
        }
        System.out.println("Finished all threads");
    }
}
