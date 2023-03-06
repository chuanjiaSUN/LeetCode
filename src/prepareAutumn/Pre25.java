package prepareAutumn;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-07-28 23:45
 */
public class Pre25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;

        while (head != null){
            ListNode tail = pre;
            for (int i = 0; i < k; i++){
                tail = tail.next;
                if (tail == null){
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverseNode(head, tail);
            head = reverse[0];
            tail = reverse[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverseNode(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail){
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

    /**
     * practice
     * */
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null){
            ListNode tail = cur;
            for (int i = 0; i < k; i++){
                tail = tail.next;
                if (tail == null){
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] nodes = reverseListNode(head, tail);
            head = nodes[0];
            tail = nodes[1];
            cur.next = head;
            tail.next = next;
            cur = tail;
            head = tail.next;
        }

        return dummy.next;
    }

    private ListNode[] reverseListNode(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (cur != tail){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return new ListNode[]{tail, head};
    }

}
