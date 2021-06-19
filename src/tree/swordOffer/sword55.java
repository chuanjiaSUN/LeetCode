package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-19 13:23
 */
public class sword55 {
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

    int ans = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        depth++;
        if (root.left == null && root.right == null)
        {
            ans = Math.max(depth, ans);
            depth--;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        depth--;
    }
}
