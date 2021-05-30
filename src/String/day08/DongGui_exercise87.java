package String.day08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-26 15:35
 */
public class DongGui_exercise87 {
    //法1 记忆化搜索，自顶向下动态规划
    int[][][] memo;// -1表示false, 1表示true， 0表示未计算
    String s1,s2;
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        this.memo = new int[length][length][length + 1];
        this.s1 = s1;
        this.s2 = s2;
        return dfs(0, 0, length);
    }

    //第一个字符串从i1开始， 第二个字符串从i2开始， 子串的长度为Length, 是否和谐
    private boolean dfs(int i1, int i2, int length) {
        if (memo[i1][i2][length] != 0 )
        {
            return memo[i1][i2][length] == 1;
        }

        //判断两个子串是否相等
        if (s1.substring(i1, i1 + length).equals( s2.substring(i2, i2 + length)))
        {
            memo[i1][i2][length] = 1;
            return true;
        }

        //判断是否存在字符 c 在两个子串中出现次数不同
        if (!checkIfSimilar(i1, i2, length))
        {
            memo[i1][i2][length] = -1;
            return false;
        }

        //枚举分割情况
        for (int i = 1; i < length; i++)
        {
            //不交换的情况
            if (dfs(i1, i2, i) && dfs(i1 + i, i2 + i, length - i))
            {
                memo[i1][i2][length] = 1;
                return true;
            }
            //交换的情况
            if(dfs(i1, i2 + length - i,i) && dfs( i1 + i, i2, length - i))
            {
                memo[i1][i2][length] = 1;
                return true;
            }
        }
        memo[i1][i2][length] = -1;
        return false;
    }

    private boolean checkIfSimilar(int i1, int i2, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = i1; i <i1 + length; i++)
        {
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = i2; i < i2 + length; i++)
        {
            char c= s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry:map.entrySet())
        {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
