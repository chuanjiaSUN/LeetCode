package dynamicPlan;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 16:36
 */
public class AtomicTest implements Runnable{
    public static void main(String[] args) {
        AtomicTest test = new AtomicTest();
        for (int i = 0; i < 10; i++)
        {
            Thread t = new Thread(test, "" + i);
            t.start();
        }
    }
    private AtomicInteger count = new AtomicInteger();
    public Integer getCount() {
        return count.get();
    }

    public void increment()
    {
        count.getAndIncrement();
    }

    @Override
    public void run() {
        increment();
        System.out.println("name"+Thread.currentThread().getName() + "count :" + getCount());
    }
}
