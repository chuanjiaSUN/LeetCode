package tree.day10;

import sun.awt.SunHints;
import sun.reflect.generics.tree.Tree;
import tree.day09.exercise235;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-23 10:35
 */
public class exercise236 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private TreeNode ancestor;
    //法 1 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return this.ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right)))
        {
            ancestor = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    // 法2 存储父节点
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q)
    {
        dfs(root);
        while ( p != null)
        {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while ( q != null)
        {
            if (visited.contains(q.val))
                return q;
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null)
        {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null)
        {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }


}
