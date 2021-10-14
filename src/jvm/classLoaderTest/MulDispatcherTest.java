package jvm.classLoaderTest;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-12 18:11
 */
public class MulDispatcherTest {
    static class Coffee{}
    static class Cola{}

    public static class Father{
       public void choose1(Coffee coffee)
        {
            System.out.println("father choose coffee");
        }
       public void choose1(Cola cola)
        {
            System.out.println("father choose cola");
        }
    }

    public static class Son extends Father{
       @Override
       public void choose1(Coffee coffee)
        {
            System.out.println("son choose coffee");
        }

        @Override
        public void choose1(Cola cola)
        {
            System.out.println("son choose cola");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.choose1(new Coffee());
        son.choose1(new Cola());
    }
}
