package String.day13;

import sun.security.util.Length;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-10 13:13
 */
public class exercise336 {
    class Node{
        int[] ch = new int[26];
        int flag;

        public Node()
        {
            flag = -1;
        }
    }
    List<Node> tree = new ArrayList<>();
    //法1 字典树
    public List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++)
        {
            insert(words[i], i);
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i =  0; i < n; i++)
        {
            int m = words[i].length();
            for (int j = 0; j <= m; j++)
            {
                if (isPalindrome(words[i], j, m - 1))
                {
                    int leftId = findWord(words[i], 0, j - 1);
                    if (leftId != -1 && leftId != i)
                    {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1))
                {
                    int rightId = findWord(words[i], j, m - 1);
                    if (rightId != -1 && rightId != i)
                    {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    private int findWord(String word, int left, int right) {
        int add = 0;
        for (int i = right; i >= left; i--)
        {
            int x = word.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0)
            {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }

    private boolean isPalindrome(String word, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len/2; i++)
        {
            if (word.charAt(left + i) != word.charAt(right - i))
            {
                return false;
            }
        }
        return true;
    }

    private void insert(String word, int id) {
        int len = word.length();
        int add = 0;
        for (int i = 0; i < len; i++)
        {
            int x = word.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0)
            {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    //哈希表
    List<String> wordsRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<>();
    public List<List<Integer>> palindromePairs1(String[] words)
    {
        int n = words.length;
        //保存翻转串
        for (String word : words)
        {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; i++)
        {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = word.length();
            if (m == 0) continue;
            for (int j = 0; j <= m; j++)
            {
                if (isPalin(word, j, m -1))
                {
                    int leftId = findWord1(word, 0, j - 1);
                    if (leftId != -1 && leftId != i)
                    {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalin(word, 0, j - 1))
                {
                    int rightId = findWord1(word, j, m - 1);
                    if (rightId != -1 && rightId != i)
                    {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    private int findWord1(String word, int left, int right) {
        return indices.getOrDefault(word.substring(left, right + 1), -1);
    }

    private boolean isPalin(String word, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len/2; i++)
        {
            if (word.charAt(left + i) != word.charAt(right - i))
            {
                return false;
            }
        }
        return true;
    }

}
