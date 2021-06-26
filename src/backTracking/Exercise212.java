package backTracking;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-26 9:21
 */
public class Exercise212 {

    /**此解法时间过长*/
    boolean[][] visited;
    Set<String> set;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        set = new HashSet<>();
        if (rows == 0)
        {
            return new ArrayList<>();
        }
        int columns = board[0].length;
        visited = new boolean[rows][columns];
        for (int i = 0; i < words.length; i++)
        {
            char[] word = words[i].toCharArray();
            List<Character> path = new ArrayList<>();
            check(board, word, path, rows, columns);
        }
        List<String> ans = new ArrayList<>();
        for (String str : set)
        {
            ans.add(str);
        }
        return ans;
    }

    private void check(char[][] board, char[] word, List<Character> path, int rows, int columns)
    {
        for (int j = 0; j < rows; j++)
        {
            for (int k = 0; k < columns; k++)
            {
                backTrack(board, word, path,0,  j, k, rows, columns);
            }
        }
    }
    private void backTrack(char[][] board, char[] word, List<Character> path,int start, int row, int column, int rows, int columns) {
        if (path.size() == word.length)
        {
            set.add(String.valueOf(word));
            return;
        }
        if (row < 0 || row >= rows || column < 0 || column >= columns)
        {
            return;
        }
        for (int[] dir : direction)
        {
            if (start < word.length && word[start] == board[row][column] && !visited[row][column])
            {
                visited[row][column] = true;
                path.add(board[row][column]);
                int newRow = row + dir[0], newCol = column + dir[1];
                backTrack(board, word, path, start + 1, newRow, newCol, rows, columns);
                visited[row][column] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode(){}
    }

    char[][] board;
    List<String> ans;
    static final int COUNT = 4;
    /**字典树优化, 前缀树的回溯
     * @param board 网格
     * @param words 单词列表
     * @return list 存储出现的单词
     * */
    public List<String> findWords1(char[][] board, String[] words)
    {
        ans = new ArrayList<>();
        this.board = board;
        TrieNode root = new TrieNode();

        //建立字典树
        for (String word : words)
        {
            TrieNode node = root;

            for (Character letter : word.toCharArray())
            {
                if (node.children.containsKey(letter))
                {
                    node = node.children.get(letter);
                }else
                {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        for (int row = 0; row < board.length; row++)
        {
            for (int column = 0; column < board[0].length; column++)
            {
                if (root.children.containsKey(board[row][column]))
                {
                    backTracking(row, column, root);
                }
            }
        }
        return ans;
    }

    private void backTracking(int row, int column, TrieNode parent) {
        Character letter = board[row][column];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null)
        {
            //匹配上了
            ans.add(currNode.word);
            //避免重复
            currNode.word = null;
        }

        board[row][column] = '#';

        int[] rowOffSet = {-1, 0, 1, 0};
        int[] colOffSet = {0, 1, 0, -1};
        for (int i = 0; i < COUNT; i++)
        {
            int newRow = row + rowOffSet[i];
            int newCol = column + colOffSet[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
            {
                continue;
            }
            if (currNode.children.containsKey(board[newRow][newCol]))
            {
                backTracking(newRow, newCol, currNode);
            }
        }

        board[row][column] = letter;

        if (currNode.children.isEmpty())
        {
            parent.children.remove(letter);
        }
    }
}
