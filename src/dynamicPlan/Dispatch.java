package dynamicPlan;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-23 21:15
 */
public class Dispatch {
    static class QQ{}
    static class Q360{}
    static class  Father{
        public void hardChoice(QQ arg)
        {
            System.out.println("father choose qq");
        }
        public void hardChoice(Q360 arg)
        {
            System.out.println("father choose 30");
        }
    }
    static  class Son extends Father{
        @Override
        public void hardChoice(QQ arg)
        {
            System.out.println("son choose qq");
        }
        @Override
        public void hardChoice(Q360 arg)
        {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new Q360());
        son.hardChoice(new QQ());

    }
}
