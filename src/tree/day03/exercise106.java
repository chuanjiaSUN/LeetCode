package tree.day03;

import tree.generateTree.exe105_Prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-16 16:15
 */
public class exercise106 {

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
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++)
        {
            indexMap.put(inorder[i], i);
        }
        return buildMyTree(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildMyTree(int[] inorder,
                                 int[] postorder,
                                 int inorderLeft,
                                 int inorderRight,
                                 int postLeft,
                                 int postRight) {
        if (inorderLeft > inorderRight) return null;

        int postRoot = postRight;
        int inRoot = indexMap.get(postorder[postRoot]);
        int leftSize = inRoot - inorderLeft;

        TreeNode root = new TreeNode(postorder[postRoot]);
        root.left = buildMyTree(inorder, postorder, inorderLeft, inRoot - 1, postLeft, postLeft + leftSize - 1);//分好区间
        root.right = buildMyTree(inorder, postorder, inRoot + 1, inorderRight, postLeft + leftSize, postRight - 1);
        return root;
    }

    //递归 写法2
    private int[] postorder;
    private int[] inorder;
    private int postRoot;
    public TreeNode buildTree1(int[] inorder, int[] postorder)
    {
        this.postorder = postorder;
        this.postRoot = postorder.length - 1;
        this.inorder = inorder;

        int len = inorder.length;
        indexMap = new HashMap<>();
        int index = 0;
        for (int val : inorder)
        {
            indexMap.put(val, index++);
        }
        return helper(0, len - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right) return null;
        int rootVal = postorder[postRoot];
        int inRoot = indexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        postRoot--;
        root.right = helper(inRoot + 1, right);
        root.left = helper(left, inRoot - 1);

        return root;
    }

    //迭代写法
    public TreeNode buildTree2(int[] inorder, int[] postorder)
    {
        int len = inorder.length;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(postorder[len - 1]);
        stack.push(root);
        int inorderIndex = len - 1;

        for (int i = len - 2; i >= 0; i--)
        {
            int postVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex])
            {
                node.right = new TreeNode(postVal);
                stack.push(node.right);
            }else
            {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex])
                {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postVal);
                stack.push(node.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        exercise106 e = new exercise106();
        int[] inorder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
        TreeNode treeNode = e.buildTree(inorder, postOrder);

    }
}
