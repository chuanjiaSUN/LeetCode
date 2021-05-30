package Arrays.day01;

/**
 * @author sunchuanjia
 * @Description #79 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2021-03-06 14:17
 */
public class exercise79 {
    public boolean exist(char[][] board, String word) {
        int high = board.length;
        int width = board[0].length;
        boolean[][] visited = new boolean[high][width];
        for(int i =0 ;i<high;i++){
            for(int j=0;j<width;j++){
                boolean flag = checkedExistChar(board,visited,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkedExistChar(char[][] board, boolean[][] visited,int i, int j,String s, int k){
        if(board[i][j] != s.charAt(k)){
            return false;
        }
        if(k == s.length()-1){
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        int[][] directed = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir:directed){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI >= 0 && newI< board.length && newJ>=0 && newJ<board[0].length){
                if(!visited[newI][newJ]){
                    boolean flag = checkedExistChar(board, visited, newI, newJ, s, k + 1);
                    if(flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

}
