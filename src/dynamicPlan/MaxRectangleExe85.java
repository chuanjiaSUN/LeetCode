package dynamicPlan;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-04 9:25
 */
public class MaxRectangleExe85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
        {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == '1')
                {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0 ; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == '0')
                {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--)
                {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, width * ( i - k + 1));
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
    /**单调栈*/
    public int maximalRectangle1(char[][] matrix)
    {
        int m = matrix.length;
        if (m == 0)
        {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == '1')
                {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ret = 0;
        for (int j = 0; j < n; j++)
        {
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < m; i++)
            {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j])
                {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--)
            {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j])
                {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = 0; i < m; i++)
            {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

}
