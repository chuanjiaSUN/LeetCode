package jvm.javaC;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-27 21:24
 */
public class SugarTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        int sum = 0;
        for (int i : list)
        {
            sum += i;
        }
        System.out.println(sum);
    }
}
