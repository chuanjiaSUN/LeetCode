package tree.generateTree;

import sun.reflect.generics.tree.Tree;
import tree.day26.exercise1028;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-08 10:43
 */
public class exe1028_Prac {
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
    //类似 迭代生成 二叉树， 用栈维护已经遍历过的节点
    public TreeNode recoverFromPreorder(String traversal)
    {
        Stack<TreeNode> stack = new Stack<>();
        int pos = 0;// 维护遍历的位置

        while (pos < traversal.length())
        {
            int depth = 0;
            while (pos < traversal.length() && traversal.charAt(pos) == '-')
            {
                pos++;
                depth++;
            }
            int val = 0;
            while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos)))
            {
                val = val * 10 + (traversal.charAt(pos) - '0');
                pos++;
            }
            TreeNode node = new TreeNode(val);
            if (depth == stack.size())
            {
                if (!stack.isEmpty())
                {
                    stack.peek().left = node;
                }
            }else
            {
                while (depth != stack.size())
                {
                    stack.pop();
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        while (stack.size() > 1)
        {
            stack.pop();
        }
        return stack.peek();
    }
}
