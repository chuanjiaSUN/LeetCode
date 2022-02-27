package num100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-24 16:15
 */
public class Exe98 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**法1 递归*/
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int minValue, int maxValue) {
        if (root == null){
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue){
            return false;
        }
        return dfs(root.left, minValue, root.val) && dfs(root.right, root.val, maxValue);
    }

    /**单调栈检查*/
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;

        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
