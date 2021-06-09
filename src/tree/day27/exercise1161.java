package tree.day27;

import tree.Mirrors.exe1038_Prac;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-09 14:05
 */
public class exercise1161 {
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
    //BFS
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int ans = 1;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (maxSum < sum)
            {
                maxSum = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }

    //DFS
    int n = 10000;
    int[] levelSum;
    int depth = 1;
    public int maxLevelSum1(TreeNode root)
    {
        levelSum = new int[n];
        inorder(root, 1);

        levelSum[0] = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i <= depth; i++)
        {
            maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
        }
        return maxIdx;
    }

    private void inorder(TreeNode root, int level) {
        if (root != null)
        {
            levelSum[level] += root.val;
            depth = Math.max(depth, level);
            inorder(root.left, level + 1);
            inorder(root.right, level + 1);
        }
    }

}
