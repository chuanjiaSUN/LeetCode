package tree.swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-17 11:51
 */
public class exe0407 {
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

    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
        {
            indexMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int rootIndex = preStart;
        int rootVal = preorder[rootIndex];
        int inIndex = indexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) return root;
        int leftSize = inIndex - inStart;
        root.left = dfs(preorder, rootIndex + 1, rootIndex  + leftSize, inorder, inStart, inIndex - 1);
        root.right = dfs(preorder, rootIndex + 1 + leftSize , preEnd, inorder, inIndex + 1, inEnd);
        return root;
    }
}
