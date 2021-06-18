package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-18 11:33
 */
public class sword27 {
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
    public TreeNode mirrorTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
