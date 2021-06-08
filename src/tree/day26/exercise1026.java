package tree.day26;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 10:05
 */
public class exercise1026 {
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
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, int min, int max) {
        if (root == null) return ;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        if (root.left == null && root.right == null)
        {
            ans = Math.max(ans, Math.abs(max - min));
        }
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}
