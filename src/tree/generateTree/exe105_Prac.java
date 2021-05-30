package tree.generateTree;

import tree.day03.exercise105;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-16 12:48
 */
public class exe105_Prac {
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
    //递归建树，为了避免每次递归时遍历数组寻找根节点，可以将根节点存到哈希表中
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int len = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorder.length; i++)
        {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        int preRoot = preLeft;
        int inRoot = indexMap.get(preorder[preRoot]);

        int sizeOfLeft = inRoot - inLeft;
        TreeNode root = new TreeNode(inorder[inRoot]);
        root.left = buildMyTree(preorder, inorder, preLeft + 1, preLeft + sizeOfLeft, inLeft, inRoot - 1);
        root.right = buildMyTree(preorder, inorder, preLeft + sizeOfLeft + 1, preRight,inRoot + 1, inRight);
        return root;
    }

    //迭代
    public TreeNode buildTree1(int[] preorder, int[] inorder)
    {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inOrderIndex = 0;
        for (int i = 1; i < preorder.length; i++)
        {
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inOrderIndex])
            {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            }else{
                while (!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex])
                {
                    node = stack.pop();
                    inOrderIndex++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
