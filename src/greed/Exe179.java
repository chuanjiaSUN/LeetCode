package greed;

import java.util.Arrays;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-10-10 11:18
 */
public class Exe179 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for (int i = 0; i < n; i++)
        {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, (a, b) ->{
            String sa = a + b, sb = b + a;
            return sb.compareTo(sa);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs)
        {
            sb.append(str);
        }
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0')
        {
            k++;
        }
        return sb.substring(k);
    }

    public String largestNumber1(int[] nums){
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++)
        {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x)
            {
                sx *= 10;
            }
            while (sy <= y)
            {
                sy *= 10;
            }
            return (int)(-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0)
        {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr)
        {
            ret.append(num);
        }
        return ret.toString();
    }

}
