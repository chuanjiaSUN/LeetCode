package num100;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-02-24 20:44
 */
public class Exe105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, Integer> index = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++){
            index.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0,  n - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int preRoot = preLeft;
        int inRoot = index.get(preorder[preRoot]);

        TreeNode root = new TreeNode(preorder[preRoot]);
        int sizeLeftNum = inRoot - inLeft;

        root.left = build(preorder, inorder, preLeft + 1, preLeft + sizeLeftNum, inLeft, inRoot - 1);
        root.right = build(preorder, inorder, preLeft + sizeLeftNum + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    /**迭代遍历*/
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0){
            return null;
        }
        TreeNode root  = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        int indexIndex = 0;
        int len = preorder.length;
        for (int i = 1; i < len; i++){
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[indexIndex]){
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[indexIndex]){
                    node = stack.pop();
                    indexIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
