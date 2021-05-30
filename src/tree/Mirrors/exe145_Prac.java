package tree.Mirrors;

import tree.day07.exercise145;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 13:44
 */
public class exe145_Prac {
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
    //迭代
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null)
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
    public List<Integer> postorderTraversal1(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        if ( root == null) return ans;

        TreeNode predecessor = null, curRoot = root;
        while (curRoot != null)
        {
            predecessor = curRoot.left;
            if (predecessor != null)
            {
                while (predecessor.right != null && predecessor.right != curRoot)
                {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null)
                {
                    predecessor.right = curRoot;
                    curRoot = curRoot.left;
                    continue;
                }else
                {
                    //遍历完左子树了,恢复树的形状
                    predecessor.right = null;
                    addPath(ans, curRoot.left);
                }
            }
            curRoot = curRoot.right;
        }
        addPath(ans, curRoot.right);
        return ans;
    }

    private void addPath(List<Integer> ans, TreeNode node) {
        int count = 0;
        while (node != null)
        {
            ans.add(node.val);
            count++;
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
