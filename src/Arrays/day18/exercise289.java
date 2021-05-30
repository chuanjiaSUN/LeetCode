package Arrays.day18;

/**
 * @author sunchuanjia
 * @Description 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * @create 2021-03-24 13:34
 */
public class exercise289 {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m==0||n==0)return;
        int[][] cells = new int[m][n];
        int[] neighbors = {0,1,-1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
               cells[i][j] = board[i][j];
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //统计每一个细胞周围的活细胞数量
                int liveNeighbors = 0;
                for(int row=0;row<3;row++)
                {
                    for(int col=0;col<3;col++)
                    {
                        if(!(neighbors[row]==0 && neighbors[col]==0)){
                            int r =  (i + neighbors[row]);
                            int c =  (j + neighbors[col]);
                            if((r<m && r>=0 ) && (c<n && c>=0) && (cells[r][c] ==1 ))
                            {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }
                if((cells[i][j] == 1) && (liveNeighbors<2 || liveNeighbors > 3)){
                    board[i][j] = 0;
                }
                if((cells[i][j] == 0) && (liveNeighbors == 3))
                {
                    board[i][j] = 1;
                }
            }
        }
    }

    //法2 让每个存活的去影响周围的8个元素
    public void gameOfLife1(int[][] board){
        int m = board.length;
        int n = board[0].length;
        //给每个存活细胞周围细胞都加10
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]%10==1)
                {
                    affectCell(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]/10==3 &&board[i][j]%10==0)
                {
                    board[i][j] = 1;
                } else if(board[i][j]/10 > 3 && board[i][j]%10 ==1)
                {
                    board[i][j] = 0;
                }else if(board[i][j]%10 == 1 && ( board[i][j]/10 ==2 || board[i][j]/10 == 3 ))
                {
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }
    public void affectCell(int[][] board,int x,int y)
    {
        int m = board.length;
        int n = board[0].length;
        int[] neighbors = {0,1,-1};
        for(int row =0;row<3;row++)
        {
            for(int col=0;col<3;col++)
            {
                int newRow = x + neighbors[row];
                int newCol = y + neighbors[col];
                if(newRow >=0 && newRow < m && newCol >=0 && newCol<n && !((newRow==x) && (newCol==y)))
                {
                    board[newRow][newCol] += 10;
                }
            }
        }
    }
    //法3 原地更新，添加多余的状态，保存过去和现在的状态 -1为活细胞死去，2为死细胞复活
    public void gameOfLife2(int[][] board){
        int m = board.length;
        int n = board[0].length;
        int[] neighbors = {0,1,-1};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int liveNeighbor = 0;
                for(int row = 0; row < 3; row++)
                {
                    for(int col = 0; col < 3; col++)
                    {
                        if(!(neighbors[row]==0&&neighbors[col]==0))
                        {
                            int newRow = i + neighbors[row];
                            int newCol = j + neighbors[col];
                            if( (newRow>=0 && newRow<m) && (newCol>=0 && newCol<n) && Math.abs(board[newRow][newCol])==1 )
                            {
                                liveNeighbor += 1;
                            }
                        }
                    }
                }

                if(board[i][j]==1 && (liveNeighbor<2 || liveNeighbor>3))
                {
                    board[i][j] = -1;
                }
                if(board[i][j]==0 && (liveNeighbor == 3))
                {
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == -1)
                {
                    board[i][j] = 0;
                }
                if(board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
            }
        }
    }
}
