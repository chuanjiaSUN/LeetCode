package tree.day04;

import tree.day03.exercise107;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-17 12:39
 */
public class exercise108 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) return null;
        int rootIndex = (left + right + 1) >> 1;
        TreeNode root = new TreeNode(nums[rootIndex]);

        root.left = build(nums, left, rootIndex - 1);
        root.right = build(nums, rootIndex + 1, right);
        return root;
    }
}
