package tree.DFS;

import tree.day19.exercise700;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-01 11:58
 */
public class exe687_Prac {
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
    public int longestUnivaluePath(TreeNode root)
    {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int lCount = 0, rCount = 0;
        if (root.left != null && root.val == root.left.val)  lCount += left + 1; //若val不相等，则没有延申出去
        if (root.right != null && root.val == root.right.val) rCount += right + 1;
        ans = Math.max(ans, lCount + rCount);
        return Math.max(lCount, rCount);
    }
}
