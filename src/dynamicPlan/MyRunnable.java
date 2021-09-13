package dynamicPlan;

import java.util.Date;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 16:00
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +command+ "Start . time :" + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() +command+ "End . time :" + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "command='" + command + '\'' +
                '}';
    }
}
