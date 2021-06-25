package backTracking;

import sun.plugin.services.WPlatformService;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-25 14:09
 */
public class WordDictionary {
    /** Initialize your data structure here. */
    Set<String> wordSet;
    Map<Integer, Set<String>> lengthMap;
    public WordDictionary() {
        wordSet = new HashSet<>();
        lengthMap = new HashMap<>();
    }

    public void addWord(String word) {
        wordSet.add(word);
        Set<String> defaultSet = lengthMap.getOrDefault(word.length(), new HashSet<>());
        defaultSet.add(word);
        lengthMap.put(word.length(), defaultSet);
    }

    public boolean search(String word) {
        boolean complete = wordSet.contains(word);
        return complete || backTrack(word);
    }

    private boolean backTrack(String word) {
        int len = word.length();
        if(!lengthMap.containsKey(len))
        {
            return false;
        }
        Set<String> words = lengthMap.get(len);
        for (String str : words)
        {
            if (check(str, word, len))
            {
                return true;
            }
        }
        return false;
    }

    private boolean check(String str, String word, int len) {
        for (int i = 0; i < len; i++)
        {
            if(word.charAt(i) == '.')
            {
                continue;
            }
            if (str.charAt(i) != word.charAt(i))
            {
                return false;
            }
        }
        return true;
    }

    /**字典树*/
    class Node{
        boolean isEnd;
        Node[] children = new Node[26];
        Node(){
             for (int i = 0; i < COUNT; i++)
             {
                children[i] = null;
             }
             isEnd = false;
        }
    }
    /**法2 */
    Node root;
    static final int COUNT = 26;
    public WordDictionary(int x){
        root = new Node();
    }
    public void addWord1(String word){
        Node cur = root;
        int n = word.length();
        for (int i = 0; i < n; i++)
        {
            if (cur.children[word.charAt(i) - 'a'] == null)
            {
                cur.children[word.charAt(i) - 'a'] = new Node();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isEnd = true;
    }
    public boolean search1(String word){
        return searchDictTree(word, this.root);
    }

    private boolean searchDictTree(String word, Node root) {
        Node node = root;
        int len = word.length();
        for (int i = 0; i < len; i++)
        {
            char c = word.charAt(i);
            if (c != '.' && node.children[c - 'a'] == null){
                return false;
            }
            if (c == '.')
            {
                //对每一个孩子节点进行遍历
                for (int j = 0; j < COUNT; j++)
                {
                    if (node.children[j] != null)
                    {
                        if (searchDictTree(word.substring(i + 1, len), node.children[j]))
                        {
                            return true;
                        }
                    }
                }
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isEnd;
    }
}
