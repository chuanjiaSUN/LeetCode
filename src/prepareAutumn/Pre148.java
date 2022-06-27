package prepareAutumn;

import java.util.PriorityQueue;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-27 22:08
 */
public class Pre148 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode cur = head;
        while (cur != null){
            queue.add(cur);
            cur = cur.next;
        }
        cur = head;
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
        }
        return head.next;
    }

    /**插排*/
    public ListNode sortList1(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode last = head;
        ListNode cur = head.next;
        while (cur != null){
            if (last.val <= cur.val){
                last = last.next;
            }else{
                ListNode prev = dummy;
                while (prev.next.val <= cur.val){
                    prev = prev.next;
                }
                last.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = last.next;
        }
        return dummy.next;
    }
    /**归并*/
    public ListNode sortList2(ListNode head) {
        return sort(head, null);
    }

    private ListNode sort(ListNode head, ListNode tail) {
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sort(head, mid);
        ListNode list2 = sort(mid, tail);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null && temp2 != null){
            if (temp1.val <= temp2.val){
                cur.next = temp1;
                temp1 = temp1.next;
            }else{
                cur.next = temp2;
                temp2 = temp2.next;
            }
            cur = cur.next;
        }
        if (temp1 != null){
            cur.next = temp1;
        }else if (temp2 != null){
            cur.next = temp2;
        }
        return dummy.next;

    }
}
