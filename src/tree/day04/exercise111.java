package tree.day04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-17 13:20
 */
public class exercise111 {
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int ans = Integer.MAX_VALUE;
        if (root.left != null)
        {
            ans = Math.min(ans, minDepth(root.left));
        }
        if (root.right != null)
        {
            ans = Math.min(ans, minDepth(root.right));
        }
        return ans + 1;
    }

    //bfs
    class QueueNode{
        TreeNode node;
        int depth;
        public QueueNode(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int minDepth2(TreeNode root)
    {
        if (root == null) return 0;
        Queue<QueueNode> queue= new LinkedList<>();
        queue.offer(new QueueNode(root, 1));

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                QueueNode node = queue.poll();
                int depth = node.depth;
                if (node.node.left == null && node.node.right == null) return depth;
                if (node.node.left != null) queue.offer(new QueueNode(node.node.left, depth + 1));
                if (node.node.right != null) queue.offer(new QueueNode(node.node.right, depth + 1));
            }
        }
        return 0;
    }


}
