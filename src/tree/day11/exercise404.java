package tree.day11;

import tree.dynamicPlanning.exercise337;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-24 14:52
 */
public class exercise404 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null)
        {
            ans += isLeaf(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeaf(root.right))
        {
            ans += dfs(root.right);
        }
        return ans;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null &&  node.right == null;
    }

    // BFS
    public int sumOfLeftLeaves1(TreeNode root)
    {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (node.left != null)
                {
                    if (node.left.left == null && node.left.right == null)
                    {
                        ans += node.left.val;
                    }else
                    {
                        queue.offer(node.left);
                    }
                }
                if (node.right != null)
                {
                    if (!(node.right.right == null && node.right.left == null))
                    {
                        queue.offer(node.right);
                    }
                }
            }
        }
        return ans;
    }
}
