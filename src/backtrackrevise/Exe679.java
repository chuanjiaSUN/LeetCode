package backtrackrevise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-30 14:06
 */
public class Exe679 {
    private static final double TARGET_VALUE = 24;
    private static final double COMPARE_TARGET = 1e-6;
    public boolean judgePoint24(int[] cards) {
        return helper(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }

    private boolean helper(double[] nums) {
        if (nums.length == 1)
        {
            return Math.abs(nums[0] - TARGET_VALUE) < COMPARE_TARGET;
        }
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                double[] nextCal = new double[nums.length - 1];
                for (int k = 0, pos = 0; k < nums.length; k++)
                {
                    if (k != i && k != j)
                    {
                        nextCal[pos++] = nums[k];
                    }
                }
                for (double num : calculate(nums[i], nums[j]))
                {
                    nextCal[nums.length - 1] = num;
                    if (helper(nextCal))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<Double> calculate(double num1, double num2) {
        List<Double> ans = new ArrayList<>();
        ans.add(num1 + num2);
        ans.add(num1 - num2);
        ans.add(num2 - num1);
        ans.add(num1 * num2);
        if (Math.abs(num1) > COMPARE_TARGET)
        {
            ans.add(num2 / num1);
        }
        if (Math.abs(num2) > COMPARE_TARGET)
        {
            ans.add(num1 / num2);
        }
        return ans;
    }
}
