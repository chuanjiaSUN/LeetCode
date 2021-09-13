package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-13 15:02
 */
public class TestDemo {
    private String name;

    public TestDemo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
