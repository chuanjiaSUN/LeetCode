package tree.day28;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 11:50
 */
public class exercise1145 {
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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xRoot = findNode(root, x);
        int left = dfsNum(xRoot.left);
        int right = dfsNum(xRoot.right);
        if (left > (n >> 1)) return true;
        else if (right > (n >> 1)) return true;
        else if (left + right < (n >> 1)) return true;
        return false;
    }

    private int dfsNum(TreeNode node) {
        if (node == null) return 0;
        return dfsNum(node.left) + dfsNum(node.right) + 1;
    }

    private TreeNode findNode(TreeNode root, int x) {
        if (root == null) return null;
        if (root.val == x) return root;
        TreeNode left = findNode(root.left, x);
        TreeNode right = findNode(root.right, x);
        return left != null ? left : right;
    }
}
