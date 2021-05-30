package tree.day07;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 10:27
 */
public class exercise145 {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.add(root.val);
    }

    //BFS
    public List<Integer> postorderTraversal1(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty())
        {
            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev)
            {
                ans.add(root.val);
                prev = root;
                root = null;
            }else
            {
                stack.push(root);
                root = root.right;
            }
        }
        return ans;
    }

    //Morris
    public List<Integer> postorderTraversal2(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeNode predecessor = null, p1 = root;

        while (p1 != null)
        {
            predecessor = p1.left;
            if (predecessor != null)
            {
                while (predecessor.right != null && predecessor.right != p1)
                {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null)
                {
                    predecessor.right = p1;
                    p1 = p1.left;
                    continue;
                }else
                {
                    //遍历完左子树
                    predecessor.right = null;
                    addPath(ans, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(ans, root);
        return ans;
    }

    private void addPath(List<Integer> ans, TreeNode node) {
        int count = 0;
        while ( node != null)
        {
            count++;
            ans.add(node.val);
            node = node.right;
        }
        int left = ans.size() - count, right = ans.size() - 1;
        while (left < right)
        {
            int temp = ans.get(left);
            ans.set(left, ans.get(right));
            ans.set(right, temp);
            left++;
            right--;
        }
    }
    
}
