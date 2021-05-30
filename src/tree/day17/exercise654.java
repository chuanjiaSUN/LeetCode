package tree.day17;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-30 10:38
 */
public class exercise654 {
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return generateTree(nums, 0, nums.length - 1);
    }

    private TreeNode generateTree(int[] nums, int left, int right) {
        if (left > right) return null;
        int rootIndex = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = generateTree(nums, left, rootIndex - 1);
        root.right = generateTree(nums, rootIndex + 1, right);
        return root;
    }

    private int findMax(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE, index = 0;
        for (int i = left; i <= right; i++)
        {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
