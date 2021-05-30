package LinkedList.day39;

import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-04-14 11:23
 */
public class exercise876 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x)
        {
            val = x;
            this.next = null;
        }
        ListNode(int val, ListNode next){this.val = val; this.next = next;}

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    //快慢指针
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow =head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
