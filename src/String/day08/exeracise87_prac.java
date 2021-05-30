package String.day08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-26 16:14
 */
public class exeracise87_prac {
    //递归 自顶向下
    int[][][] memo;// -1 为 false ,1 为 true
    String s1,s2;
    public boolean isScramble(String s1, String s2)
    {
        int length = s1.length();
        memo = new int[length][length][length + 1];// s1起点 i1,s2起点i2, 串长从0 到 1
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, length);
    }

    //递归判断两个 串  是否和谐
    private boolean dfs(int i1, int i2, int length) {
        if (memo[i1][i2][length] != 0)
        {
            return memo[i1][i2][length] == 1;
        }
        //判断两个子串是否相等
        if (s1.substring(i1,i1 + length).equals(s2.substring(i2,i2 + length)))
        {
            memo[i1][i2][length] = 1;
            return true;
        }
        //判断两个子串字符数是否都相同
        if (!checkNoSimilary(i1,i2,length))
        {
            memo[i1][i2][length] = -1;
            return false;
        }

        //判断其他情况，即从不同长度分割，满足一个就返回true
        for (int i = 1; i < length; i++)
        {
            //不交换
            if (dfs(i1,i2, i) && dfs(i1 + i, i2 + i, length - i))
            {
                memo[i1][i2][length] = 1;
                return true;
            }
            //交换
            if (dfs(i1,i2 + length - i, i) && dfs(i1 + i, i2, length - i)) {
                memo[i1][i2][length] = 1;
                return true;
            }
        }

        //找完都还没返回true，则不和谐
        memo[i1][i2][length] = -1;
        return false;
    }

    private boolean checkNoSimilary(int i1, int i2, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = i1; i < i1 + length; i++)
        {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = i2; i < i2 + length; i++)
        {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if (entry.getValue() != 0 ) return false;
        }
        return true;
    }
}
