package tree.Bfs;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-19 13:21
 */
public class exe124_Prac {
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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        if (root == null) return 0;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(maxGain(root.left), 0);
        int rightSum = Math.max(maxGain(root.right), 0);
        int sum = root.val + leftSum + rightSum;
        maxSum = Math.max(sum, maxSum);
        return root.val + Math.max(leftSum, rightSum);//节点的最大贡献值
    }
}
