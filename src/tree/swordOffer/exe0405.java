package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-16 12:46
 */
public class exe0405 {
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

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && root.val <= low) return false;
        if (high != null && root.val >= high) return false;

        if (!dfs(root.left, low, root.val)) return false;
        if (!dfs(root.right, root.val, high)) return false;
        return true;
    }

    public boolean isValidBST1(TreeNode root)
    {
        return dfs1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs1(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val >= maxValue || root.val <= minValue) return false;
        return dfs1(root.left, minValue, root.val) && dfs1(root.right, root.val, maxValue);
    }


}
