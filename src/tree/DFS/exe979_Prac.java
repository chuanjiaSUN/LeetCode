package tree.DFS;

import tree.day24.exercise979;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-06 14:39
 */
public class exe979_Prac {
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
    public int distributeCoins(TreeNode root)
    {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
