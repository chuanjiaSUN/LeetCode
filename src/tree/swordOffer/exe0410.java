package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-17 11:37
 */
public class exe0410 {
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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null) return false;
        if (t2 == null) return false;
        if (t1.val == t2.val)
        {
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        }else
        {
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
        }
    }


}
