package dynamicPlan;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.atomic.*;

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

    @Test
    public void AtomicIntegerArrayTest()
    {
        int[] nums = new int[]{1,2,3,4,5,6};
        AtomicIntegerArray atomicArray = new AtomicIntegerArray(nums);
        for (int i = 0; i < atomicArray.length(); i++)
        {
            System.out.println(atomicArray.get(i));
        }
        int tempValue = atomicArray.getAndSet(0, 2);
        System.out.println("tempValue: " + tempValue + "atomic: " + atomicArray);
        tempValue = atomicArray.getAndIncrement(0);
        System.out.println("tempValue: " + tempValue + "atomic: " + atomicArray);
        tempValue = atomicArray.getAndAdd(0, 5);
        System.out.println("tempValue: " + tempValue + "atomic: " + atomicArray);
    }

    @Test
    public void atomicReferenceTest()
    {
        AtomicReference<Person> reference = new AtomicReference<>();
        Person person = new Person("SunChuan", 25);
        reference.set(person);
        Person person1 = new Person("SunChuanJia", 26);
        reference.compareAndSet(person, person1);
        System.out.println(reference.get().getName());
        System.out.println(reference.get().getAge());
    }
    class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    @Test
    public void atomicMarkAbleReferenceTest()
    {
        final Boolean initialRef = null;
        boolean initialMark = false;
        AtomicMarkableReference<Boolean> reference = new AtomicMarkableReference<>(initialRef , initialMark);
        System.out.println("ref : " + reference.getReference() + "mark: " + reference.isMarked());

        final Boolean newRef1 = true;
        boolean newMark1 = true;
        reference.compareAndSet(initialRef, newRef1, initialMark, newMark1);
        System.out.println("ref : " + reference.getReference() + "mark: " + reference.isMarked());

        boolean[] arr = new boolean[1];
        Boolean currentValue = reference.get(arr);
        boolean curMark = arr[0];
        System.out.println("ref : " + currentValue + "mark: " + curMark);

        final Boolean attempMark = reference.attemptMark(newRef1, false);
        System.out.println("ref : " + reference.getReference() + "mark: " + reference.isMarked());

        reference.set(initialRef , initialMark);
        System.out.println("ref : " + reference.getReference() + "mark: " + reference.isMarked());

    }
    @Test
    public void atomicIntegerFieldUpdaterTest()
    {
        AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
        User user = new User("ChuanJia", 25);
//        int andAdd = updater.getAndAdd(user, 2);
        int andAdd = updater.getAndIncrement(user);
        System.out.println(andAdd);
        System.out.println(updater.get(user));
    }

    class User{
        private String name;
        public volatile int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}
