package tree.day04;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-17 12:43
 */
public class exercise110 {

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
    //自顶向下的递归
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHigh = dfs(root.left);
        int rightHigh = dfs(root.right);
        return Math.abs(leftHigh - rightHigh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }

    //自底向上的递归, 类似于后序遍历
    public boolean isBalanced1(TreeNode root)
    {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHigh = height(root.left);
        int rightHigh = height(root.right);
        if (leftHigh == -1 || rightHigh == -1 || Math.abs(leftHigh - rightHigh) > 1) return -1;
        else return Math.max(leftHigh, rightHigh) + 1;
    }
}
