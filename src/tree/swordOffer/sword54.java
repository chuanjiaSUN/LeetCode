package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-19 16:21
 */
public class sword54 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans = 0, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root != null)
        {
            inorder(root.right);
            if (k == 0) return;
            if (--k == 0) ans = root.val;
            inorder(root.left);
        }
    }


}
