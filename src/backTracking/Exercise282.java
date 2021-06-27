package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-27 11:10
 */
public class Exercise282 {

    List<String> ans;
    String digits;
    long target;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        if (num.length() == 0)
        {
            return ans;
        }
        this.digits = num;
        this.target = target;
        recurse(0, 0, 0, 0, new ArrayList<String>());
        return ans;
    }

    private void recurse(int index, long previous, long current, long value, ArrayList<String> ops) {
        String nums = this.digits;

        if (index == nums.length())
        {
            if (value == this.target && current == 0)
            {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach( v -> sb.append(v));
                ans.add(sb.toString());
            }
            return;
        }

        current = current * 10 + Character.getNumericValue(nums.charAt(index));
        String currentValue = Long.toString(current);
        int length = nums.length();

        if (current > 0)
        {
            recurse(index + 1, previous, current, value, ops);
        }

        ops.add("+");
        ops.add(currentValue);
        recurse(index + 1, current, 0, value + current, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);

        if (ops.size() > 0)
        {
            ops.add("-");
            ops.add(currentValue);
            recurse(index + 1, -current, 0, value - current, ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);

            ops.add("*");
            ops.add(currentValue);
            recurse(index + 1,
                    current * previous,
                    0,
                    value - previous + (current * previous),
                    ops);
            ops.remove(ops.size() - 1);
            ops.remove(ops.size() - 1);
        }
    }
}
