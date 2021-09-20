package dynamicPlan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-19 10:16
 */
public class Exe542 {
    /**BFS*/
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++)
        {
             for (int j = 0; j < n; j++)
             {
                 if (mat[i][j] == 0)
                 {
                     queue.offer(new int[]{i, j});
                     seen[i][j] = true;
                 }
             }
        }

        while (!queue.isEmpty())
        {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; d++)
            {
                int ni = i + directions[d][0];
                int nj = j + directions[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj])
                {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }
    /**动规*/
    public int[][] updateMatrix1(int[][] mat)
    {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] == 0)
                {
                    dist[i][j] = 0;
                }
            }
        }
        //只有向左 和 竖直向上
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i - 1 >= 0)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        //只有向左,竖直向下
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = 0; j < n; j++)
            {
                if (i + 1 < m)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j - 1 > 0)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        //只有向右,竖直向上
        for (int i = 0; i < m; i++)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (i - 1 >= 0)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j + 1 < n)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j  +1] + 1);
                }
            }
        }
        //只有向右，竖直向下
        for (int i = m - 1; i >= 0; i--)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (i + 1 < m)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 <  n)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }

}
