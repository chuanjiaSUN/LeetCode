package tree.revise;

import jdk.nashorn.internal.objects.NativeUint8Array;
import tree.day32.exercise1609;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-08-02 21:14
 */
public class Exercise111TwicePractice {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int ans = Integer.MAX_VALUE;
    /**preDfs*/
    public int minDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        dfs(root, 1);
        return ans;
    }

    private void dfs(TreeNode root, int curLength) {
        if (root == null)
        {
            return;
        }
        if (root.left == null && root.right == null)
        {
            ans = Math.min(ans, curLength);
            return;
        }
        if (root.left != null)
        {
            dfs(root.left, curLength + 1);
        }
        if (root.right != null)
        {
            dfs(root.right, curLength + 1);
        }
    }
    /**lastTravel*/
    public int minDepth1(TreeNode root)
    {
        return lastTravel(root);
    }

    private int lastTravel(TreeNode root) {
        if (root == null)
        {
            return 0;
        }
        int leftDepth = lastTravel(root.left);
        int rightDepth = lastTravel(root.right);
        if (root.left != null && root.right == null)
        {
            return leftDepth + 1;
        }
        if (root.right != null && root.left == null)
        {
            return rightDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**Bfs*/
    public int minDepth2(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        if (root == null)
        {
            return 0;
        }
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode curNode = queue.poll();
                if (curNode.left != null)
                {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null)
                {
                    queue.offer(curNode.right);
                }
                if (curNode.left == null && curNode.right == null)
                {
                    res = Math.min(res, depth);
                    return res;
                }
            }
            depth++;
        }
        return depth;
    }
}
