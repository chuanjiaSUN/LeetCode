package tree;

import tree.DFS.exe129_Prac;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-30 21:15
 */
public class Practice236 {
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

    public TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
        {
            return false;
        }
        boolean lSon = dfs(root.left, p, q);
        boolean rSon = dfs(root.right, p, q);
        if ((lSon && rSon) || (root.val == p.val || root.val == q.val) && (lSon || rSon))
        {
            ans = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }
}
