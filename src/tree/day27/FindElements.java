package tree.day27;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-09 14:47
 */
public class FindElements {
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
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = dfs(root, 0);
    }

    private TreeNode dfs(TreeNode root, int target) {
        if (root == null) return new TreeNode(0);
        root.val = target;
        if (root.left != null) root.left = dfs(root.left, target * 2 + 1);
        if (root.right != null) root.right = dfs(root.right, target * 2 + 2);
        return root;
    }


    public boolean find(int target) {
        return dfsFind(root, target);
    }

    private boolean dfsFind(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        return dfsFind(root.left, target) || dfsFind(root.right, target);
    }
}
