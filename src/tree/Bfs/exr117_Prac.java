package tree.Bfs;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-19 11:38
 */
public class exr117_Prac {
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

    Node nextStart = null;
    Node last = null;
    //使用已经建立的next指针连接下一层的next
    public Node connect1(Node root)
    {
        if (root == null) return null;
        Node start = root;

        while (start != null)
        {
            last = null;
            nextStart = null;
            for (Node cur = start; cur != null; cur = cur.next)
            {
                if (cur.left != null) handle(cur.left);
                if (cur.right != null) handle(cur.right);
            }
            start = nextStart;//到下一层最左边不为null的节点去
        }
        return root;
    }

    private void handle(Node node)
    {
        if (last != null)
        {
            last.next = node;
        }
        if (nextStart == null) nextStart = node;
        last = node;
    }
}
