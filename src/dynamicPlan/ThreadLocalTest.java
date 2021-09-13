package dynamicPlan;


import java.util.HashSet;
import java.util.Random;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 15:01
 */
public class ThreadLocalTest implements Runnable{
    public static ThreadLocal<TestDemo> localTemp = ThreadLocal.withInitial(() -> new TestDemo("测试"));
    public static ThreadLocal<TestDemo> localTemp1 = ThreadLocal.withInitial(() -> new TestDemo("test"));
    public static ThreadLocal<HashSet<TestDemo>> localTemp2 = ThreadLocal.withInitial(() -> new HashSet<TestDemo>(){
    });

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        for (int i = 0; i < 10; i++)
        {
            Thread t = new Thread(test, " " + i);
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("thread name: " + Thread.currentThread().getName() + "ThreadLocal: " + localTemp.get().getName());
        System.out.println("thread name: " + Thread.currentThread().getName() + "ThreadLocal: " + localTemp1.get().getName());
        System.out.println("thread name: " + Thread.currentThread().getName() + "ThreadLocal: " + localTemp2.get().size());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        localTemp.get().setName("测试" + System.currentTimeMillis());
        localTemp1.get().setName("----------------------" + System.currentTimeMillis());
        localTemp2.get().add(new TestDemo("经验"));
        localTemp2.get().add(new TestDemo("利益"));
        System.out.println("thread name: " + Thread.currentThread().getName() + "ThreadLocal: " + localTemp.get().getName());
        System.out.println("thread name: " + Thread.currentThread().getName() + "ThreadLocal: " + localTemp1.get().getName());
        System.out.println("thread name: " + Thread.currentThread().getName() + "ThreadLocal: " + localTemp2.get().toString());
    }
}
