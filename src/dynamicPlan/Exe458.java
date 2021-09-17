package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-17 11:40
 */
public class Exe458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testCount = minutesToTest / minutesToDie + 1;
        return (int)Math.ceil(Math.log(buckets)/Math.log(testCount));
    }
}
