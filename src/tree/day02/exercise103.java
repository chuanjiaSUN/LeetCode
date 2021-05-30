package tree.day02;

import java.util.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-15 11:25
 */
public class exercise103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int length = 1;

        while (!queue.isEmpty() )
        {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                if (length % 2 == 0)
                {
                    deque.offerFirst(node.val);
                }else{
                    deque.offerLast(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            length++;
            ans.add(new LinkedList<>(deque));
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int length = 1;

        while (!queue.isEmpty())
        {
            Deque<Integer> path = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i <size; i++)
            {
                TreeNode node = queue.poll();
                if (length % 2 == 0)
                {
                    path.offerFirst(node.val);
                }else
                {
                    path.offerLast(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            length++;
            ans.add(new LinkedList<>(path));
        }
        return ans;
    }
}
