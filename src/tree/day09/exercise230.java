package tree.day09;

import tree.day08.exercise222;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-22 15:19
 */
public class exercise230 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //迭代
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }

    //递归  中序遍历
    public int kthSmallest1(TreeNode root, int k)
    {
        List<Integer> list = new ArrayList<>();
        return inOrderDFS(root, list).get(k - 1);
    }

    private List<Integer> inOrderDFS(TreeNode root, List<Integer> ans) {
        if (root == null) return ans;
        inOrderDFS(root.left, ans);
        ans.add(root.val);
        inOrderDFS(root.right, ans);
        return ans;
    }
}
