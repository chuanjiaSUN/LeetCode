package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-24 21:46
 */
public class Pre124 {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int prev = left + right + root.val;
        ans = Math.max(ans, prev);
        return root.val + Math.max(left, right);
    }
}
