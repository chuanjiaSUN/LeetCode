package JZ_Offer_linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-17 11:12
 */
public class offer35 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //法2 拼接，拆分
    public Node copyRandomList1(Node head)
    {
        if (head == null) return head;
        Node cur = head;
        //复制next
        while ( cur != null)
        {
            Node add = new Node(cur.val);
            add.next = cur.next;
            cur.next = add;
            cur = add.next;
        }
        cur = head;
        // 复制random
        while (cur != null)
        {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        //拆分
        cur = head.next;
        Node pre = head, ans = head.next;
        while (cur.next != null)
        {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return ans;
    }
}
