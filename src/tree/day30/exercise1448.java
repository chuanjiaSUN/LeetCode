package tree.day30;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-12 13:36
 */
public class exercise1448 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode root, int prev) {
        if (root == null) return;
        if (root.val >= prev)
        {
            ans++;
            prev = root.val;
        }
        dfs(root.left, prev);
        dfs(root.right, prev);
    }
}
