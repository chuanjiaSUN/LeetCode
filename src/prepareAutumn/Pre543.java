package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-12 22:56
 */
public class Pre543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
