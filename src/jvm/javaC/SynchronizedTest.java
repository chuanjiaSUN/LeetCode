package jvm.javaC;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-28 17:16
 */
public class SynchronizedTest {
    public void method()
    {
        synchronized (this)
        {
            System.out.println("synchronized!!!");
        }
    }

    public static void main(String[] args) {

    }
}
