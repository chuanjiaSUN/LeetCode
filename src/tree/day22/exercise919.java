package tree.day22;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 11:08
 */
public class  exercise919 {

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

    TreeNode root;
    Deque<TreeNode> deque;

    public exercise919(TreeNode root) {
        this.root = root;
        deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null) deque.offerLast(node);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null) node.left = deque.peekLast();
        else{
            node.right = deque.peekLast();
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
