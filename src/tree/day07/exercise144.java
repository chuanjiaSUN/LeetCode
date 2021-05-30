package tree.day07;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 10:11
 */
public class exercise144 {
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
    // dfs
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }

    //dfs
    public List<Integer> preorderTraversal1(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty() || node != null)
        {
            while (node != null )
            {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return ans;
    }

    //Morris
    public List<Integer> preorderTraversal2(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeNode p1 = root, p2 = null;

        while (p1 != null)
        {
            p2 = p1.left;
            if (p2 != null)
            {
                while ( p2.right != null && p2.right != p1)
                {
                    p2 = p2.right;
                }
                if (p2.right == null)
                {
                    ans.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                }else
                {
                    p2.right = null;
                }
            }else
            {
                ans.add(p1.val);
            }
            p1 = p1.right;
        }
        return ans;
    }
}
