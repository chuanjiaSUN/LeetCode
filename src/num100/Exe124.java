package num100;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-27 10:40
 */
public class Exe124 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxGin(root);
        return maxSum;
    }

    private int maxGin(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGin = Math.max(maxGin(root.left), 0);
        int rightGin = Math.max(maxGin(root.right), 0);

        int single = leftGin + rightGin + root.val;
        maxSum = Math.max(maxSum, single);

        return Math.max(leftGin, rightGin) + root.val;
    }


}
