package LinkedList.day35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-10 14:26
 */
public class exercise138_practice {
    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val)
        {
            this.val = val;
        }
    }
    //回溯
    Map<Node, Node> visited = new HashMap<>();
    public Node copyRandomList(Node head)
    {
        if (head == null)return null;
        if(visited.containsKey(head))return visited.get(head);
        Node newNode = new Node(head.val);
        visited.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
    //O(N)空间迭代
    Map<Node, Node> visitedMap = new HashMap<>();
    public Node copyRandomList1(Node head)
    {
        if(head == null)return null;
        Node newNode = new Node(head.val);
        Node oldNode = head;
        visitedMap.put(head, newNode);
        while (oldNode != null)
        {
            newNode.random = getCloneNode(oldNode.random);
            newNode.next = getCloneNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedMap.get(head);
    }

    private Node getCloneNode(Node head) {
        if(head == null) return null;
        if(visitedMap.containsKey(head))return visitedMap.get(head);
        else{
            Node node = new Node(head.val);
            visitedMap.put(head, node);
            return visitedMap.get(head);
        }
    }
    // O(1)空间迭代
    public Node copyRandomList2(Node head)
    {
        if( head == null ) return null;
        Node listNewNode = null;
        Node oldNode = head;
        while (oldNode != null)
        {
            listNewNode = new Node(oldNode.val);
            Node nextNode = oldNode.next;
            listNewNode.next = nextNode;
            oldNode.next = listNewNode;
            oldNode = nextNode;
        }
        oldNode = head;
        while (oldNode != null)
        {
            oldNode.next.random = (oldNode.random!= null) ? oldNode.random.next : null;
            oldNode = oldNode.next.next;
        }
        oldNode = head;
        Node new_list_node = head.next;
        listNewNode = head.next;
        while (oldNode != null)
        {
            oldNode.next = oldNode.next.next;
            listNewNode.next = (listNewNode.next != null) ? listNewNode.next.next : null;
            oldNode = oldNode.next;
            listNewNode = listNewNode.next;
        }
        return new_list_node;
    }
}
