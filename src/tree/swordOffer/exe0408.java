package tree.swordOffer;

import sun.awt.SunHints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-17 11:18
 */
public class exe0408 {
    class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, TreeNode> indexMap;
    Set<Integer> visited;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        indexMap = new HashMap<>();
        visited = new HashSet<>();
        dfs(root);
        while (p != null)
        {
            visited.add(p.val);
            p = indexMap.get(p.val);
        }
        while (q != null)
        {
            if (visited.contains(q.val)) return q;
            q = indexMap.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null)
        {
            indexMap.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null)
        {
            indexMap.put(root.right.val, root);
            dfs(root.right);
        }
    }

    //法2 递归
    TreeNode ans;
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        ans = null;
        dfs1(root, p, q);
        return ans;
    }

    private boolean dfs1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs1(root.left, p, q);
        boolean right = dfs1(root.right, p, q);
        if ((left && right) || (root.val == p.val ||  root.val == q.val)&&(left || right)) ans = root;
        return left || right || (root.val == q.val || root.val == p.val);
    }
}
