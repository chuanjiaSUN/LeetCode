package jvm.classLoaderTest;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-12 17:45
 */
public class DispatcherTest {
    static class Human{

    }

    static class Man extends Human{

    }
    static class WoMan extends Human{
    }
    public void say(Human human)
    {
        System.out.println("hello, guy");
    } public void say(Man human)
    {
        System.out.println("hello, man");
    } public void say(WoMan human)
    {
        System.out.println("hello, woman");
    }


    public static void main(String[] args) {
        DispatcherTest test = new DispatcherTest();
        Human man = new Man();
        Human woman = new WoMan();
        test.say(man);
        test.say(woman);
    }
}
