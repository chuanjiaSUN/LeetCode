package tree.day16;

import tree.day15.exercise543;

import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 12:45
 */
public class exercise606 {
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
    //DFS
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        if (root.left == null && root.right == null) return root.val + "";
        if (root.right == null) return root.val + "(" + tree2str(root.left) + ")";
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    //迭代
    public String tree2str1(TreeNode root)
    {
        if (root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty())
        {
            root = stack.peek();
            if (visited.contains(root))
            {
                stack.pop();
                s.append(")");
            }else
            {
                visited.add(root);
                s.append("(" + root.val);
                if (root.left == null && root.right != null)
                {
                    s.append("()");
                }
                if (root.right != null)stack.push(root.right);
                if (root.left != null) stack.push(root.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}
