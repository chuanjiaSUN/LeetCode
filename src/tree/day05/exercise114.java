package tree.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-18 11:24
 */
public class exercise114 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //前序遍历 后 展开
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderTraver(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++)
        {
            TreeNode prev = list.get( i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }

    private void preOrderTraver(TreeNode root, List<TreeNode> list) {
        if ( root != null )
        {
            list.add(root);
            preOrderTraver(root.left, list);
            preOrderTraver(root.right, list);
        }
    }

    //迭代前序遍历
    public void flatten1(TreeNode root)
    {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty())
        {
            while (node != null)
            {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();//回退
            node = node.right;//遍历右子树
        }
        for (int i = 1; i < list.size(); i++)
        {
            TreeNode prev = list.get(i - 1);
            TreeNode cur = list.get(i);
            prev.left = null;
            prev.right = cur;
        }
    }
    //前序遍历与展开同时进行
    public void flatten2(TreeNode root)
    {
        //存储右子树的节点
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty())
        {
            TreeNode curr = stack.pop();
            if (prev != null)
            {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) stack.push(right);
            if (left != null) stack.push(left);
            prev = curr;
        }
    }

    //寻找前驱节点， 空间复杂度为O(1)
    public void flatten3(TreeNode root)
    {
        TreeNode curr = root;
        while (curr != null)
        {
            if (curr.left != null)
            {
                TreeNode next = curr.left;
                TreeNode predecessor = curr.right;
                while (predecessor.right != null)
                {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
