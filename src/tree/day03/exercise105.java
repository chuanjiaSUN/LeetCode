package tree.day03;

import tree.day02.exercise104;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-16 12:45
 */
public class exercise105 {
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
    private Map<Integer, Integer> indexMap;

    //递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++)
        {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) return null;
        int preorderRoot = preOrderLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);

        TreeNode root = new TreeNode(preorder[preorderRoot]);

        int sizeOfLeftTree = inorderRoot - inOrderLeft;
        root.left = buildMyTree(preorder, inorder, preOrderLeft + 1, preOrderLeft + sizeOfLeftTree, inOrderLeft, inorderRoot - 1);
        root.right = buildMyTree(preorder, inorder, preOrderLeft + sizeOfLeftTree + 1, preOrderRight, inorderRoot + 1, inOrderRight);
        return root;
    }

    //迭代
    //栈存储已经遍历过的节点，用一个指针指向中序遍历，当前栈顶节点不等于中序遍历指针的值时，说明当前栈顶节点还有左子树，否则中序遍历
    //指针的值应该为当前栈顶节点
    //当中序遍历的指针值与栈顶相同时，说明已经遍历完当前栈顶的左子树，则前序遍历的下一个值x应该是栈内中某一个元素的右儿子
    //根据中序遍历的规律，栈内元素与中序遍历相同时，依次弹出，因为这时是从底向上弹出左子树，当中序遍历的值与栈顶元素不同时，说明上一个
    //弹出的栈顶元素的右儿子就是那个值x --->>> 因为它出现在了当前栈顶元素与上一次弹出元素的中序遍历之间
    //当前栈顶元素一定在上次弹出元素更上层，他们之间如果存在元素，只能是其中的右儿子，


    public TreeNode buildTree1(int[] preorder, int[] inorder)
    {
        if (preorder == null || preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        int inOrderIndex = 0;
        stack.push(root);
        for (int i = 1; i < preorder.length; i++)
        {
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            //栈顶节点与中序遍历值不同，说明栈顶元素存在左儿子，并且还没有前序遍历到当前中序遍历值来，当前中序遍历值是最下面的值
            if (stack.peek().val != inorder[inOrderIndex])
            {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            }else
            {
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

    //递归练习
    public TreeNode buildTree2(int[] preorder, int[] inorder)
    {
        int len = preorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++)
        {
            indexMap.put(inorder[i], i);//用来找根节点的索引
        }
        return buildPracTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildPracTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        int preRoot = preLeft;
        int inRoot = indexMap.get(preorder[preRoot]);
        int size = inRoot - inLeft;
        TreeNode root = new TreeNode(preorder[preRoot]);

        root.left = buildPracTree(preorder, inorder, preLeft + 1, preLeft + size, inLeft, inRoot - 1);
        root.right = buildPracTree(preorder, inorder, preLeft + size + 1,preRight, inRoot + 1, inRight);

        return root;
    }
}
