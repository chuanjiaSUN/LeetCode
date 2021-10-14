package jvm.classLoaderTest;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-12 17:57
 */
public class DynamicDispatcher {
    static abstract class Human{
        protected abstract void sayHello();
    }
    static class Man extends Human{

        @Override
        protected void sayHello() {
            System.out.println("man say");
        }
    }

    static class woman extends Human{

        @Override
        protected void sayHello() {
            System.out.println("woman say");
        }
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new woman();
        man.sayHello();
        woman.sayHello();
    }
}
