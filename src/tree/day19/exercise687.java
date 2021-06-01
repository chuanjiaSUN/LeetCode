package tree.day19;

import tree.day18.exercise671;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-01 11:15
 */
public class exercise687 {
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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int arrowL = 0, arrowR = 0;
        if (root.left != null && root.val == root.left.val)
        {
            arrowL += left + 1;
        }
        if (root.right != null && root.val == root.right.val)
        {
            arrowR += right + 1;
        }
        ans = Math.max(ans, arrowL + arrowR);
        return Math.max(arrowL, arrowR);
    }


}
