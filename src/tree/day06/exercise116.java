package tree.day06;

import jdk.nashorn.internal.runtime.FindProperty;
import tree.day05.exercise114;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-19 10:30
 */
public class exercise116 {
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
    //BFS
    public Node connect(Node root) {
        if (root == null)return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++)
            {
                Node cur = queue.poll();
                if ( i < size - 1)
                {
                    cur.next = queue.peek();
                }
                list.add(cur);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            for (int i = 0; i < list.size(); i++)
            {
                Node node = list.get(i);
                if (i < list.size() - 1)
                {
                    node.next = list.get(i + 1);
                }else
                {
                    node.next = null;
                }
            }
        }
        return root;
    }

    //法2 BFS优化
    public Node connect1(Node root) {
        if (root == null)return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++)
            {
                Node cur = queue.poll();
                if ( i < size - 1)
                {
                    cur.next = queue.peek();
                }
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return root;
    }

    //法3 利用上一层已经建立起来的next指针为下一层建立连接
    public Node connect2(Node root)
    {
        if (root == null) return root;

        Node leftMost = root;

        while (leftMost.left != null)
        {
            //遍历这一层节点组成的链表，为下一层建立连接
            Node head = leftMost;
            while ( head != null)
            {
                head.left.next = head.right;
                if (head.next != null)
                {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

}
