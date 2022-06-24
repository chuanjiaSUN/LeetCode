package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-23 22:07
 */
public class Pre105 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0){
            return new TreeNode();
        }
        int m = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < m; i++){
            map.put(inorder[i], i);
        }
        return build(preorder,0, m - 1, inorder, 0, m - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR){
            return null;
        }
        int inRoot = map.get(preorder[preL]);
        int preRoot = preL;

        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftLeaves = inRoot - inL;
        root.left = build(preorder, preL + 1, preL + leftLeaves, inorder, inL, inRoot - 1);
        root.right = build(preorder, preL + leftLeaves + 1, preR, inorder, inRoot + 1, inR);
        return root;
    }

    /**栈*/
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++){
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]){
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]){
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
