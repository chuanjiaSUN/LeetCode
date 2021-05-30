package tree.day01;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-14 15:27
 */
public class exe98_prac {
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
    public boolean isValidBST(TreeNode root)
    {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int minValue, int maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }
    //中序遍历
    public boolean isValidBST1(TreeNode root)
    {
        double inOrder = -Double.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();

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
