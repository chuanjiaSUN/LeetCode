package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-24 16:42
 */
public class Exe101 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){}
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode le, TreeNode ri) {
        if (le == null && ri == null){
            return true;
        }
        if (le == null || ri == null){
            return false;
        }
        return le.val == ri.val && check(le.left, ri.right) && check(le.right, ri.left);
    }
}
