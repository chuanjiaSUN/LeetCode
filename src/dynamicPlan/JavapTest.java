package dynamicPlan;

import org.junit.Test;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-20 21:35
 */
public class JavapTest {
    final int DEMO_VAL = 11;
    int values;
    public int inc()
    {
        return ++values;
    }

    public int getDEMO_VAL() {
        return DEMO_VAL;
    }

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }
    public JavapTest()
    {}
}
