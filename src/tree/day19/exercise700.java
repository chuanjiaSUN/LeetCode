package tree.day19;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-01 11:33
 */
public class exercise700 {
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
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) return dfs(root.right, val);
        if (root.val > val) return dfs(root.left, val);
        return null;
    }
}
