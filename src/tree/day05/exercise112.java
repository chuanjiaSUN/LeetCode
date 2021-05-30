package tree.day05;

import tree.generateTree.exe95_Prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-18 10:05
 */
public class exercise112 {
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

    //递归
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    //迭代
    public boolean hasPathSum1(TreeNode root, int targetSum)
    {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queue.offer(root);
        queVal.offer(root.val);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                int path = queVal.poll();
                if (path == targetSum && node.left == null && node.right == null) return true;
                if (node.left != null){
                    queue.offer(node.left);
                    queVal.offer(node.left.val + path);
                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                    queVal.offer(node.right.val + path);
                }
            }
        }
        return false;
    }

    //迭代优化
    public boolean hasPathSum2(TreeNode root, int targetSum)
    {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queue.offer(root);
        queVal.offer(root.val);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            int path = queVal.poll();
            if (node.left == null && node.right == null && path == targetSum) return true;
            if (node.left != null)
            {
                queue.offer(node.left);
                queVal.offer(node.left.val + path);
            }
            if (node.right != null)
            {
                queue.offer(node.right);
                queVal.offer(node.right.val  + path);
            }
        }
        return false;
    }
}
