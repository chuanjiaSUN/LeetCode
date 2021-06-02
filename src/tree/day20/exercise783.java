package tree.day20;

import tree.DFS.exe687_Prac;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-02 10:30
 */
public class exercise783 {
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
    int ans = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre == -1)
        {
            pre = root.val;
        }else
        {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        inorder(root.right);
    }

}
