package backtrackrevise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-26 10:17
 */
public class Exe212 {
    class TrieNode
    {
        String word = null;
        Map<Character, TrieNode> children = new HashMap<>();
        public TrieNode(){}
    }


    char[][] board;
    List<String> ans;
    static final int DIR_COUNT = 4;
    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words)
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
            for (int col = 0; col < board[0].length; col++)
            {
                if (root.children.containsKey(board[row][col]))
                {
                    backTrack(row, col, root);
                }
            }
        }

        return ans;
    }

    /**从字典树根节点开始，在网格中寻找能否匹配*/
    private void backTrack(int row, int col, TrieNode parent) {
        Character letter = board[row][col];
        TrieNode curNode = parent.children.get(letter);

        if (curNode.word != null)
        {
            ans.add(curNode.word);
            curNode.word = null;
        }

        board[row][col] = '#';
        for (int[] dir : direction)
        {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length)
            {
                continue;
            }
            if (curNode.children.containsKey(board[newRow][newCol]))
            {
                backTrack(newRow, newCol, curNode);
            }
        }

        board[row][col] = letter;
        if (curNode.children.isEmpty())
        {
            parent.children.remove(letter);
        }
    }
}
