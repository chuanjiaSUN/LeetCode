package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-24 17:02
 */
public class Exe104 {
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

    int ans = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return ans;
        }
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }
}
