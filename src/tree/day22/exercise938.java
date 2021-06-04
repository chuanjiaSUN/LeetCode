package tree.day22;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 11:26
 */
public class exercise938 {
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return ans;
    }

    private void inorder(TreeNode root, int low, int high) {
        if (root == null) return;
        inorder(root.left, low, high);
        if (root.val >= low && root.val <= high) ans += root.val;
        inorder(root.right, low, high);
    }


}
