package Arrays.day11;

import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来
 * @create 2021-03-17 15:47
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class DFS_Tree_Array_exercise105 {
    private Map<Integer,Integer> indexMap ;

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    //法1 递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for(int i=0;i<n;i++)//构建哈希映射，方便找根节点
        {
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right) return null;

        //前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        //先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);

        //得到左子树中的节点数目
        int size_left_subTree = inorder_root - inorder_left;
        //递归的构造左子树，并连接到根节点
        //先序遍历中[从左边界 + 1开始的size_left_subTree]个元素就对应了中序遍历中[从左边界开始到根节点定位-1的元素]
        root.left = myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subTree,inorder_left,inorder_root-1);
        //递归的构造右子树，并连接到根节点
        root.right = myBuildTree(preorder,inorder,preorder_left + size_left_subTree + 1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }

    //法2 迭代
    public TreeNode buildTree1(int[] preorder, int[] inorder){
        if(preorder==null||preorder.length==0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inOrderIndex = 0;
        for(int i=1;i<preorder.length;i++)
        {
            int preOrderVal = preorder[i];
            TreeNode node = stack.peek();
            if(node.val != inorder[inOrderIndex])
            {
                node.left = new TreeNode(preOrderVal);
                stack.push(node.left);
            }else{
                while(!stack.isEmpty() && stack.peek().val == inorder[inOrderIndex])
                {
                    node = stack.pop();
                    inOrderIndex ++;
                }
                node.right = new TreeNode(preOrderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    //复现递归生成二叉树
    public TreeNode buildTree2(int[] preorder, int[] inorder){
        int n = preorder.length;
        Map<Integer,Integer> indexHashMap = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            indexHashMap.put(inorder[i],i);//方便在inorder中查找根节点
        }

        return buildMyTree(preorder,inorder,0,n-1,0,n-1,indexHashMap);
    }

    private TreeNode buildMyTree(int[] preorder, int[] inorder, int preOrder_left, int preOrder_right, int inOrder_left, int inOrder_right,Map<Integer,Integer> indexHashMap) {
        if(preOrder_left>preOrder_right) return null;

        int preOrder_root = preOrder_left;
        int inOrder_root = indexHashMap.get(preorder[preOrder_root]);

        TreeNode root = new TreeNode(preorder[preOrder_root]);//根节点

        int sizeOfLeftSubTree = inOrder_root - preOrder_root;//左子树数目

        root.left = buildMyTree(preorder,inorder,preOrder_left+1,preOrder_left+sizeOfLeftSubTree,inOrder_left,inOrder_root-1,indexHashMap);//左子树
        root.right = buildMyTree(preorder,inorder,preOrder_left+sizeOfLeftSubTree+1,preOrder_right,inOrder_root+1,inOrder_right,indexHashMap);
        return root;
    }

    //复现迭代实现二叉树，前序+中序
    public TreeNode buildTree3(int[] preorder, int[] inorder){
        if(preorder.length==0||preorder==null) return null;
        int indexOfInOrder = 0;
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for(int i=1;i<length;i++)
        {
            int preOrder_value = preorder[i];//遍历到的前序元素
            TreeNode node = stack.peek();
            if(stack.peek().val != inorder[indexOfInOrder])
            {
                node.left = new TreeNode(preOrder_value);//当前遍历元素为栈顶节点左孩子
                stack.push(node.left);
            }else{
                //弹出最后一个与index对应元素相等的节点x，即找到了它的双亲。
//                退出循环时，index指向的元素出现在了 x 与 x 在栈中的下一个节点的中序遍历之间
                while(!stack.isEmpty() && inorder[indexOfInOrder] == stack.peek().val)
                {
                    node = stack.pop();
                    indexOfInOrder++;
                }
                node.right = new TreeNode(preOrder_value);
                stack.push(node.right);
            }
        }
        return root;
    }
}
