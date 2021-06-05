package tree.day23;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-05 11:06
 */
public class exercise965 {
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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode root, int pre) {
        if (root == null) return true;
        if (root.val == pre)
        {
            return dfs(root.left, root.val) && dfs(root.right, root.val);
        }else{
            return false;
        }
    }
}
