package tree.day28;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 10:07
 */
public class exercise1123 {
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
    int depth;
    TreeNode prev;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == right) return root;
        else if (left > right) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    TreeNode ans = null;
    int pre = 0;
    public TreeNode lcaDeepestLeaves1(TreeNode root)
    {
        if (root == null) return null;
        dfs1(root, 0);
        return ans;
    }

    private int dfs1(TreeNode root, int depth) {
        if (root == null) return depth;
        int left = dfs1(root.left, depth + 1);
        int right = dfs1(root.right, depth + 1);
        depth = Math.max(left, right);
        if (left == right && depth >= pre)
        {
            pre = depth;
            ans = root;
        }
        return depth;
    }


}
