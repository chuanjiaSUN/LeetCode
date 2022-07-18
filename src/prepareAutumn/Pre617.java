package prepareAutumn;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-14 22:23
 */
public class Pre617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }
        TreeNode root = new TreeNode();
        if (root1 == null){
            root.val = root2.val;
            root.left = dfs(null, root2.left);
            root.right = dfs(null, root2.right);
        }
        if (root2 == null){
            root.val = root1.val;
            root.left = dfs(root1.left, null);
            root.right = dfs(root1.right, null);
        }
        root.val = root1.val + root2.val;
        root.left = dfs(root1.left, root2.left);
        root.right = dfs(root1.right, root2.right);
        return root;

    }
}
