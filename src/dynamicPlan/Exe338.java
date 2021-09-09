package dynamicPlan;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-09 11:05
 */
public class Exe338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++)
        {
            dp[i] = countOnes(i);
        }
        return dp;
    }

    private int countOnes(int i) {
        int ones = 0;
        while (i > 0)
        {
            i &= (i - 1);
            ones++;
        }
        return ones;
    }
    /**动规, 从最高位*/
    public int[] countBits1(int n)
    {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++)
        {
            if ((i & (i - 1) )== 0)
            {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }
    /**动规， 最低有效位*/
    public int[] countBits2(int n)
    {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
    /**动规，最低设置位*/
    public int[] countBits3(int n)
    {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            bits[i] = bits[(i & (i - 1))] + 1;
        }
        return bits;
    }
}
