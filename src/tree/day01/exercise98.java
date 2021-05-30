package tree.day01;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 15:05
 */
public class exercise98 {
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
    //递归
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }

    //中序遍历
    public boolean isValidBST1(TreeNode root)
    {
        Deque<TreeNode> stack = new LinkedList<>();
        double inOrder = -Double.MAX_VALUE;

        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inOrder) return false;
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }
}
