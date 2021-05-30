package Arrays.day24;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-03-30 10:22
 */
public class exercise661 {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        if(m == 0 || M == null) return new int[][]{};
        int n = M[0].length;
        int[][] answer = new int[m][n];
        for(int i = 0; i < m; ++i)
        {
            for(int j =0 ; j < n ; ++j)
            {
               int count = 0;
               for(int nr = i - 1;nr<=i+1;++nr)
               {
                   for(int nc = j - 1;nc <= j + 1;++nc)
                   {
                       if(0<=nr && nr<m && 0<=nc && nc<n)
                       {
                           answer[i][j] += M[nr][nc];
                           count++;
                       }
                   }
               }
               answer[i][j] /= count;
            }
        }
        return answer;
    }
}
