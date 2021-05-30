package Arrays.day26;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * @create 2021-04-01 9:48
 */
public class DFS_exercise695 {
    //DFS
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0)
        {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid, i + 1, j);
        num += dfs(grid, i - 1, j);
        num += dfs(grid, i, j + 1);
        num += dfs(grid, i, j - 1);
        return num;
    }

    //DFS + Stack
    public int maxAreaOfIsland1(int[][] grid)
    {
        int ans = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                int cur = 0;
                Deque<Integer> stackI = new LinkedList<>();
                Deque<Integer> stackJ = new LinkedList<>();
                stackI.push(i);
                stackJ.push(j);
                while(!stackI.isEmpty())
                {
                    int cur_i = stackI.pop(), cur_j = stackJ.pop();
                    if(cur_i <0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[i].length || grid[cur_i][cur_j] != 1)
                    {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for(int indedx = 0; indedx != 4; indedx++)
                    {
                        int next_i = cur_i + di[indedx], next_j = cur_j + dj[indedx];
                        stackI.push(next_i);
                        stackJ.push(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }


    //BFS
    public int maxAreaOfIsland2(int[][] grid){
        int ans = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                int cur = 0;
                Queue<Integer> queueI = new LinkedList<>();
                Queue<Integer> queueJ = new LinkedList<>();
                queueI.offer(i);
                queueJ.offer(j);
                while (!queueI.isEmpty())
                {
                    int cur_i = queueI.poll(), cur_j = queueJ.poll();
                    if( cur_i <0 || cur_j < 0 || cur_i >= grid.length || cur_j >= grid[i].length || grid[cur_i][cur_j] != 1)
                    {
                        continue;
                    }
                    cur++;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for(int index = 0; index != 4; index++)
                    {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queueI.offer(next_i);
                        queueJ.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}
