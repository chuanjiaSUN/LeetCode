package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-01 21:07
 */
public class Trie {
    Trie[] children;
    boolean end;
    public Trie() {
        children = new Trie[26];
        end = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null){
                node.children[c - 'a'] = new Trie();
            }
            node = node.children[c - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word) {
        Trie node = searchPrfix(word);
        return node != null && node.end;
    }

    private Trie searchPrfix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null){
                return null;
            }
            node = node.children[ch - 'a'];
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPrfix(prefix) != null;
    }
}
