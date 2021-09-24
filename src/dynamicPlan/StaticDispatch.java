package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-23 20:36
 */
public class StaticDispatch {
    static abstract class Human{

    }
    static class Man extends  Human{

    }
    static class Women extends Human{

    }
    public void sayHello(Human guy)
    {
        System.out.println("hello guy");
    }
    public void sayHello(Man man)
    {
        System.out.println("hello man");
    }
    public void sayHello(Women women)
    {
        System.out.println("hello women");
    }

    public static void main(String[] args) {
        Man man = new Man();
        Women women = new Women();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello((Human) man);
        sr.sayHello(women);
        sr.sayHello(man);
        sr.sayHello(women);
        sr.sayHello(man);
    }

}
