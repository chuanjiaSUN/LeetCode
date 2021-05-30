package String.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-10 16:34
 */
public class exercise336_trie {
    class Node
    {
        int[] ch = new int[26];
        int flag;
        public Node()
        {
            flag = -1;
        }
    }
    List<Node> tree = new ArrayList<>();//字典树，每一个节点代表一个字符子串，这里用列表表示
    //使用字典树进行遍历
    public List<List<Integer>> palindromePairs(String[] words)
    {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++)
        {
            insert(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        //开始遍历字符串数组
        for (int i = 0; i < n; i++)
        {
            String word = words[i];
            int len = word.length();
            //遍历每一个字符串的前缀后缀，看能否组成回文对
            for (int j = 0; j <= len; j++)
            {
                if (isPalina(word, j, len - 1))
                {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i)
                    {
                        res.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalina(word, 0, j - 1))
                {
                    int rightId = findWord(word, j, len - 1);
                    if (rightId != -1 && rightId != i)
                    {
                        res.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return res;
    }

    private int findWord(String word, int left, int right) {
        int add = 0;
        //逆序在字典树中查找
        for (int i = right; i >= left; i--)
        {
            int index = word.charAt(i) - 'a';
            if (tree.get(add).ch[index] == 0) return -1;
            add = tree.get(add).ch[index];
        }
        return tree.get(add).flag;
    }

    private boolean isPalina(String word, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++)
        {
            if (word.charAt(left + i) != word.charAt( right - i)) return false;
        }
        return true;
    }

    private void insert(String word, int id) {
        int add = 0;
        int len = word.length();
        for (int i = 0; i < len; i++)
        {
            int index = word.charAt(i) - 'a';
            if (tree.get(add).ch[index] == 0)//若字典树中没有该字符，则添加新的边
            {
                tree.add(new Node());
                tree.get(add).ch[index] = tree.size() - 1;//定义新添加字符属于的节点位置，即下一个节点
            }
            add = tree.get(add).ch[index];//若找到了该字符的位置，继续向下遍历
        }
        tree.get(add).flag = id;//表示该节点成为一个单词
    }

}
