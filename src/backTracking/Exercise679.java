package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-30 13:50
 */
public class Exercise679 {
    private static final double TARGET = 24;
    private static final double COMPARE_VALUE = 1e-6;
    public boolean judgePoint24(int[] cards) {
        return helper(new double[]{cards[0], cards[1], cards[2], cards[2], cards[3]});
    }

    private boolean helper(double[] nums) {
        if (nums.length == 1)
        {
            return Math.abs(nums[0] - TARGET) < COMPARE_VALUE;
        }
        //每次选两个不同的数进行回溯
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                double[] next = new double[nums.length - 1];
                for (int k = 0, pos = 0; k < nums.length; k++)
                {
                    if (k != i && k != j)
                    {
                        next[pos++] = nums[k];
                    }
                }
                for (double num : calculate(nums[i], nums[j]))
                {
                    next[next.length - 1] = num;
                    if (helper(next))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<Double> calculate(double num1, double num2) {
        List<Double> list = new ArrayList<>();
        list.add(num1 + num2);
        list.add(num1 - num2);
        list.add(num2 - num1);
        list.add(num1 * num2);
        if ((Math.abs(num2) > COMPARE_VALUE))
        {
            list.add(num1 / num2);
        }
        if ((Math.abs(num1) > COMPARE_VALUE))
        {
            list.add(num2 / num1);
        }
        return list;
    }
}
