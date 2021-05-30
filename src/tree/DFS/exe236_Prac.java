package tree.DFS;

import tree.day10.exercise236;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-23 11:10
 */
public class exe236_Prac {
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
    private TreeNode ancestor;
    //法 1 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        dfs(root, p, q);
        return ancestor;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == q.val || root.val == p.val) && (left || right)))
        {
            ancestor = root;
        }
        return left || right || (root.val == p.val || root.val == q.val);
    }

}
