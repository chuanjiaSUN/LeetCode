package LinkedList.day35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-10 10:48
 */
public class exercise138 {
    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val, Node next, Node random)
        {
            this.val = val;
            this.next = next;
            this.random = random;
        }
        public Node(int val)
        {
            this.val = val;
        }

    }
    //法1 两次遍历， 第一次拷贝val， 第二次拷贝next与random
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null)
        {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        cur = head;
        while (cur != null)
        {
            Node node = map.get(cur);
            node.next = map.get(cur.next);
            node.random = map.get(cur.random);

            cur = cur.next;
        }
        return map.getOrDefault(head, null);
    }
    //法2 回溯, 分别对next 与 random 进行递归调用，通过visited进行回溯

    private Map<Node, Node> visited = new HashMap<>();

    public Node copyRandomList1(Node head)
    {
        if( head == null)
        {
            return null;
        }
        if(this.visited.containsKey(head))
        {
            return this.visited.get(head);
        }
        Node node = new Node(head.val,null,null);
        this.visited.put(head, node);
        node.next = copyRandomList1(head.next);
        node.random = copyRandomList1(head.random);

        return node;
    }

    //法2 O(N)空间的迭代
    Map<Node, Node> visitedMap = new HashMap<>();
    public Node copyRandomList2(Node head)
    {

        if(head == null)
        {
            return null;
        }
        Node oldNode = head;
        Node newNode = new Node(oldNode.val, null , null);
        this.visited.put(oldNode, newNode);
        while (oldNode != null)
        {
            newNode.random = this.getClonedNode(oldNode.next);
            newNode.next = this.getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }

        return this.visitedMap.get(head);
    }

    private Node getClonedNode(Node node) {
        if(node != null)
        {
            if(this.visitedMap.containsKey(node))
            {
                return this.visitedMap.get(node);
            }else{
                this.visitedMap.put(node, new Node(node.val, null, null));
                return this.visitedMap.get(node);
            }
        }
        return null;
    }

    //法4 o1空间的迭代
    public Node copyRandomList3(Node head)
    {
        if(head == null) return null;
        Node ptr = head;

        while (ptr != null)
        {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        while (ptr != null)
        {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_old = head.next;
        while (ptr_old_list != null)
        {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
