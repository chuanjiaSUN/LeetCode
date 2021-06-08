package tree.day26;

import tree.day25.exercise1008;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 9:55
 */
public class exercise1022 {
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
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int cur) {
        if (root == null) return;
        cur = (cur << 1) + root.val;
        if (root.left == null && root.right == null) ans += cur;
        dfs(root.left, cur);
        dfs(root.right, cur);
    }


}
