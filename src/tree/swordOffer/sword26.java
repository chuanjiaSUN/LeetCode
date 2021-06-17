package tree.swordOffer;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-17 12:02
 */
public class sword26 {
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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
      return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null || a.val != b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }


}
