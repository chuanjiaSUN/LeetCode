package trieTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-04-24 15:37
 */
public class LeetCode212 {
    class TrieNode{
        String str;
        TrieNode[] trs = new TrieNode[26];

       public void insert(String s){
           TrieNode p = root;
           for(int i = 0; i < s.length(); i++){
               char ch = s.charAt(i);
               int index = ch - 'a';
               if (p.trs[index] == null){
                   p.trs[index] = new TrieNode();
               }
               p = p.trs[index];
           }
           p.str = s;
       }
    }
    TrieNode root;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Set<String> set = new HashSet<>();
    boolean[][] visited;
    int n, m;
    char[][] boards;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        for (String word : words){
            root.insert(word);
        }
        int rows = board.length, cols = board[0].length;
        n = rows;
        m = cols;
        boards = board;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (root.trs[board[i][j] - 'a'] != null){
                    visited[i][j] = true;
                    dfs(i, j, root.trs[board[i][j] - 'a']);
                    visited[i][j] = false;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (String str : set){
            ans.add(str);
        }
        return ans;
    }

    private void dfs(int i, int j, TrieNode tr) {
        if (tr.str != null){
            set.add(tr.str);
            return;
        }
        for (int[] dir : dirs){
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI < 0 || newI >= m || newJ < 0 || newJ >= n) {
                continue;
            }
            if (visited[newI][newJ]){
                continue;
            }
            int inx = boards[newI][newJ] - 'a';
            if (tr.trs[inx] != null){
                visited[newI][newJ] = true;
                dfs(newI, newJ, tr.trs[inx]);
                visited[newI][newJ] = false;
            }
        }
    }
}
