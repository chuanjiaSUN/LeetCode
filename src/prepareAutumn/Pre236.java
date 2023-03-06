package prepareAutumn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-02 20:15
 */
public class Pre236 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left && right || ((root.val == p.val || root.val == q.val) && (left || right))){
            ans = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

    /**
     * 存储节点
     * */
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        dfsSave(root);
        while (p != null){
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void dfsSave(TreeNode root) {
        if (root.left != null){
            map.put(root.left.val, root);
            dfsSave(root.left);
        }
        if (root.right != null){
            map.put(root.right.val, root);
            dfsSave(root.right);
        }
    }

    /**
     * practice
     * */
    TreeNode res;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        deep(root, p, q);
        return res;
    }

    private boolean deep(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return false;
        }
        boolean left = deep(root.left, p, q);
        boolean right = deep(root.right, p, q);
        if (left && right || ((p.val == root.val || q.val == root.val) && (left || right))){
            res = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> map = new HashMap<>();
        preOrder(root, map);
        Set<Integer> set = new HashSet<>();
        while (p != null){
            set.add(p.val);
            p = map.get(p.val);
        }
        while (q != null){
            if (set.contains(q.val)){
                return q;
            }
            q = map.get(q.val);
        }
        return null;
    }

    private void preOrder(TreeNode root, Map<Integer, TreeNode> map) {
        if (root == null){
            return;
        }
        if (root.left != null){
            map.put(root.left.val, root);
            preOrder(root.left, map);
        }
        if (root.right != null){
            map.put(root.right.val, root);
            preOrder(root.right, map);
        }
    }
}
