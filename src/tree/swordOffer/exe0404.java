package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-16 12:33
 */
public class exe0404 {
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

    //自底向上
    public boolean isBalanced(TreeNode root) {
        return dfs(root) >= 0;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1 || Math.abs(left -right) > 1) return -1;
        else return 1 + Math.max(left, right);
    }

    //自顶向下
    public boolean isBalanced1(TreeNode root)
    {
        if (root == null) return true;
        else{
            return Math.abs(height(root.left) - height(root.right) ) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
        }
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(height(root.left), height(root.right));
    }

}
