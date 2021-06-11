package tree.day29;



/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 11:02
 */
public class exercise1315 {
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
    int ans;
    public int sumEvenGrandparent(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val % 2 == 0)
        {
            if (root.left != null && root.left.left != null) ans += root.left.left.val;
            if (root.left != null && root.left.right != null) ans += root.left.right.val;
            if (root.right != null && root.right.left != null) ans += root.right.left.val;
            if (root.right != null && root.right.right != null) ans += root.right.right.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

    //法2
    public int sumEvenGrandparent1(TreeNode root)
    {
        if (root.left != null)
        {
            dfs1(root, root.left, root.left.left);
            dfs1(root, root.left, root.left.right);
        }
        if (root.right != null)
        {
            dfs1(root, root.right, root.right.left);
            dfs1(root, root.right, root.right.right);
        }
        return ans;
    }

    private void dfs1(TreeNode grandPa, TreeNode parent, TreeNode node) {
        if (node == null) return;
        if (grandPa.val % 2 == 0) ans += node.val;
        dfs1(parent, node, node.left);
        dfs1(parent, node, node.right);
    }
}
