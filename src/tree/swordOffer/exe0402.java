package tree.swordOffer;

import tree.DFS.exe145_Prac;

import javax.swing.tree.TreeNode;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-16 12:15
 */
public class exe0402 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) return null;
        int rootIndex = (start + end + 1) >> 1;
        TreeNode root = new TreeNode(nums[rootIndex]);
        if (start == end) return root;
        root.left = dfs(nums, start, rootIndex - 1);
        root.right = dfs(nums, rootIndex + 1, end);
        return root;
    }

}
