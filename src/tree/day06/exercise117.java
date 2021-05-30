package tree.day06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Handler;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-19 11:04
 */
public class exercise117 {
    class Node
    {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node(){};
        public Node(int val){this.val = val;}
        public Node(int val, Node left, Node right, Node next){
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Node node = queue.poll();
                if ( i < size - 1)
                {
                    node.next = queue.peek();
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
        }

        return root;
    }
    Node last = null;
    Node nextStart = null;
    public Node connect1(Node root)
    {
        if (root == null) return null;
        Node start = root;

        while (start != null)
        {
            last = null;
            nextStart = null;

            for (Node p = start; p != null; p = p.next)
            {
                if (p.left != null) handle(p.left);
                if (p.right != null) handle(p.right);
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node node) {
        if (last != null)
        {
            last.next = node;
        }
        if (nextStart == null) nextStart = node;
        last = node;
    }
}
