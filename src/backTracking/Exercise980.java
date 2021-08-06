package backTracking;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-07-17 14:50
 */
public class Exercise980 {
    int res = 0;
    private static final int END_POINT = 2;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int tr, tc;
    int sr, sc;
    int r, c;
    int[][] grid;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        r = grid.length;
        c = grid[0].length;

        int todo = 0;
        sr = 0;
        sc = 0;
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                if (grid[i][j] != -1)
                {
                    todo++;
                }
                if (grid[i][j] == 1)
                {
                    sr = i;
                    sc = j;
                }
                if (grid[i][j] == 2)
                {
                    tr = i;
                    tc = j;
                }
            }
        }
        dfs(sr, sc, todo);
        return res;
    }

    private void dfs(int beginX, int beginY, int todo) {
        todo--;
        if (todo < 0)
        {
            return;
        }
        if(beginX == tr && beginY == tc)
        {
            if (todo == 0)
            {
                res++;
            }
            return;
        }

        grid[beginX][beginY] = 3;
        for (int[] dir : directions)
        {
            int newX = beginX + dir[0];
            int newY = beginY + dir[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length)
            {
                if (grid[newX][newY] % 2 == 0)
                {
                    dfs(newX, newY, todo);
                }
            }
        }
        grid[beginX][beginY] = 0;
    }


}
