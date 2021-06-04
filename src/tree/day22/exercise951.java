package tree.day22;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 11:30
 */
public class exercise951 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left)
                ||
        dfs(root1.left, root2.left) && dfs(root1.right, root2.right);
    }
}
