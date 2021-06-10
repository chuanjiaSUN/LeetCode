package tree.day28;

import tree.day27.exercise1161;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 9:50
 */
public class exercise1110 {
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
    List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        Set<Integer> deleteTarget = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++)
        {
            deleteTarget.add(to_delete[i]);
        }
        root = dfs(root, deleteTarget);
        if (root != null)
        {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode root, Set<Integer> set) {
        if (root == null) return null;
        root.left =dfs(root.left, set);
        root.right = dfs(root.right, set);
        if (set.contains(root.val))
        {
            if (root.left != null) ans.add(root.left);
            if (root.right != null) ans.add(root.right);
            root = null;
        }
        return root;
    }
}
