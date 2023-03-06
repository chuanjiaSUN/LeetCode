package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-09-21 19:45
 */
public class Pre208Trie {
    Pre208Trie[] child;
    boolean end;
    public Pre208Trie(){
        child = new Pre208Trie[26];
        end = false;
    }
    public void insert(String word){
        Pre208Trie node = this;
        for (char ch : word.toCharArray()){
            if (node.child[ch - 'a'] == null){
                node.child[ch - 'a'] = new Pre208Trie();
            }
            node = node.child[ch - 'a'];
        }
        node.end = true;
    }

    public boolean search(String word){
        Pre208Trie node = this;
        for (char ch : word.toCharArray()){
            if (node.child[ch - 'a'] == null){
                return false;
            }
            node = node.child[ch - 'a'];
        }
        return node.end;
    }

    public boolean startsWith(String prefix){
        Pre208Trie node = this;
        for (char ch : prefix.toCharArray()){
            if (node.child[ch - 'a'] == null){
                return false;
            }
            node = node.child[ch - 'a'];
        }
        return true;
    }
}
