package tree.day08;

import sun.reflect.generics.tree.Tree;
import tree.day07.exercise129;

import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-21 11:37
 */
public class exercise222 {
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
    private int count = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        count++;
        dfs(root.left);
        dfs(root.right);
    }

    //DFS迭代
    public int countNodes1(TreeNode root)
    {
        int ans = 0;
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null)
        {
            while (root != null)
            {
                ans++;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }
}
