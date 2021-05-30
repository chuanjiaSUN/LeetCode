package tree.day02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-15 13:43
 */
public class exercise104 {
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
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans++;
        }
        return ans;
    }

    //DFS
    public int maxDepth1(TreeNode root)
    {
        if (root == null) return 0;
        else {
            int leftHigh = maxDepth(root.left) + 1;
            int rightHigh = maxDepth(root.right) + 1;
            return Math.max(leftHigh, rightHigh);
        }
    }
}
