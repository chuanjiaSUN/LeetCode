package tree.day28;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 10:52
 */
public class exercise1130 {

    //数组dp
    public int mctFromLeafValues(int[] arr) {
        int[][] maxNum = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++)
        {
            int maxValue = arr[j];
            for (int i = j; i >= 0; i--)
            {
                maxValue = Math.max(maxValue, arr[i]);
                maxNum[i][j] = maxValue;
            }
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++)
        {
            for (int i = j; i >=0; i--)
            {
                int min = Integer.MAX_VALUE;
                for (int k = i; k + 1 <= j; k++)
                {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j] + maxNum[i][k] * maxNum[k + 1][j]);
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][arr.length - 1];
    }

    //单调栈dp
    public int mctFromLeafValues1(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int ans = 0;
        for (int i = 0; i < arr.length; i++)
        {
            while (arr[i] >= stack.peek())
            {
                ans += stack.pop() * Math.min(arr[i], stack.peek());//看栈顶左右2侧的较小值, 组成一对叶子节点
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 2)
        {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }
}
